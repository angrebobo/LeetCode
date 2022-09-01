/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:27 2022/9/1
 */
public class String用例 {

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
