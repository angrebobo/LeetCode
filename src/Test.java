/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        String s = "hello,world";
        char[] arr = s.substring(5).toCharArray();
        change(s,arr);
        String arrS = new String(arr);
        System.out.println(s + "---"+arrS);
    }

    public static void change(String s, char[] arr){
        s = "beautiful";
        arr[5] = '*';
    }
}
