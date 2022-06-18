/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:26 2022/5/5
 */
public class Test {
    private float a = 1.0f;
    int b = 12;
    static int c = 1;
    public static void main(String[] args) {
        System.out.print(test());
    }
    private static int test() {
        int temp = 1;
        try {
            System.out.print(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.print(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.print(temp);
        }
    }
}
