/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:41 2022/9/3
 */
public class Test {

    public static void main(String[] args) {
        int n = 5;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += Math.log(i)/Math.log(2) + 1;
        }
        System.out.println(ans);
    }
}
