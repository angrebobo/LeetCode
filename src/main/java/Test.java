/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:36 2022/8/28
 */
public class Test {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = str2;
        String str4 = "hello";

        System.out.println(str1 == str2);      // false
        System.out.println(str1 == str3);      // false
        System.out.println(str1 == str4);      // true
        System.out.println(str2 == str3);      // true
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true
        System.out.println(str1.equals(str4)); // true
        System.out.println(str2.equals(str3)); // true
    }
}
