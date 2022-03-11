package LeetCode;


import java.util.Arrays;

/**
 * @Description TODO
 * @Author HuangSiBo
 * @Date 2022/2/13 18:25
 **/
public class Test {

    public static void main(String[] args) {
//        String tagId = "31231231231231232";
//        if(substringBefore(tagId, "_").length() >= 10){
//            System.out.println("true");
//        }
//        else
//            System.out.println("false");
//        String s = "dasd";
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(String.valueOf(chars));
        //StringBuffer buffer = new StringBuffer(String.valueOf(chars));

        String s = "abcdefgh";
        System.out.println( s.substring(0,8) );
    }

    public static String substringBefore(final String str, final String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.isEmpty()) {
            return "";
        }
        final int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}


