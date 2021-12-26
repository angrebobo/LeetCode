import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description 一个小型布隆过滤器的实现，追求更高精确度可以使用google的guava包下的工具类
 * @param
 * @return
 */
public class BloomFilter {
    public static final int NUM_SLOTS = 1024*1024*8;
    public static final int NUM_HASH = 8;
    private BigInteger bitmap = new BigInteger("0");


    private int getHash(String message, int n){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            message  = message +String.valueOf(n);
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());

            return Math.abs(bi.intValue()) % NUM_SLOTS;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BloomFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void addElement(String message){
        for(int i = 0; i < NUM_HASH; i++){
            int hashcode = getHash(message, i);
            if(!bitmap.testBit(hashcode)){
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }

    /**
     * @Description 判断元素是否在集合中
     * @param
     * @return
     */
    public boolean check(String message){
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!this.bitmap.testBit(hashcode)){
                return false;
            }
        }
        return true;
    }

    //测试代码
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        ArrayList<String> contents = new ArrayList<>();
        contents.add("fdsfsdffsdf");
        contents.add("fsdfs655hgh;;");
        contents.add("hnvbnvbrete");
        contents.add("2342346546tgert");
        contents.add("gdfgdfg\\[po[--090");

        for(int i = 0; i < contents.size(); i++){
            bloomFilter.addElement(contents.get(i));
        }
        System.out.println(bloomFilter.check("2342346546tgert"));
        System.out.println(bloomFilter.check("2342346546tgert77"));
    }
}
