package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:01 2022/1/3
 */
public class Num48 {

    static class Solution {
        public void rotate(int[][] matrix) {

        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("----原数组----");
        for(int[] num : nums){
            for(int i : num){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Solution solution = new Solution();
        solution.rotate(nums);


        System.out.println("\n" + "----翻转后的数组----");
        for(int[] num : nums){
            for(int i : num){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
