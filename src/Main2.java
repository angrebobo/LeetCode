import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:09 2022/4/24
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int[] attackPreSum = new int[n];
        int[] defendPreSum = new int[n];
        if(s.charAt(0) == '0'){
            attackPreSum[0] = 1;
            defendPreSum[0] = 0;
        }
        else {
            attackPreSum[0] = 0;
            defendPreSum[0] = 1;
        }


        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == '0'){
                attackPreSum[i] = (i+1) + attackPreSum[i-1];
                defendPreSum[i] = defendPreSum[i-1];
            }
            else {
                defendPreSum[i] =  (i+1) + defendPreSum[i-1];
                attackPreSum[i] = attackPreSum[i-1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int pos = 0; pos <= n; pos++) {
            if(pos == 0){
                int w = 0;
                int v = defendPreSum[n-1];
                min = Math.min(min, Math.abs(w-v));
            }
            else if(pos == n){
                int w = attackPreSum[n-1];
                int v = 0;
                min = Math.min(min, Math.abs(w-v));
            }
            else {
                int w = attackPreSum[pos-1];
                int v = defendPreSum[n-1] - defendPreSum[pos];
                min = Math.min(min, Math.abs(w-v));
            }
        }

        System.out.println(min);
    }
}
