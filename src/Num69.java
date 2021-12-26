/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:09 2021/5/26
 */
public class Num69 {
    public static int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == 2) return 1;
        if(x == 3) return 1;
        int left = 0;
        int right = x/2;

        while (left <= right){
            int mid = left + (right-left)/2;
            if(mid < x/mid)
                left = mid + 1;
            else if(mid > x/mid)
                right = mid - 1;
            else if(mid == x/mid)
                return mid;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(5));
    }
}
