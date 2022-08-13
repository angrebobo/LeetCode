package 笔试题.美团.八月六日;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:47 2022/8/12
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        while (n -- > 0){
            long target = Long.parseLong(input.nextLine());

            String str = "MeiTuannauTieMwow";
            long len = str.length();

            long index = target;
            while (index > len){
                len = len * 2 + 3;
            }

            while (true){
                if(len - index < 3) {
                    System.out.println("wow".charAt((int)(len - index)));
                    break;
                }else if(index <= str.length()){
                    System.out.println(str.charAt((int)(index - 1)));
                    break;
                }else if(index > (len - 3) / 2){
                    index = len - 3 - index + 1;
                    len = (len - 3) / 2;
                }else{
                    len = (len - 3) / 2;
                }
            }
        }
    }
}
