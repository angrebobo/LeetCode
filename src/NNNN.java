/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:40 2021/9/27
 */
public class NNNN {

    public static float ipToFloat(String ip){
        String[] split = ip.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for(String c : split){
            stringBuilder.append(c);
        }

        return Float.parseFloat(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        System.out.println(ipToFloat(ip));
    }
}
