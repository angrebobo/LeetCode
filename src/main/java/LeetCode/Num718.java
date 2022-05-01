package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: 第718题
 * @Data: Created in 22:47 2022/1/2
 */
public class Num718 {

    static class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int max = 0;
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[][] dp = new int[len1][len2];

            //dp数组初始化
            for (int i = 0; i < len1; i++) {
                if(nums1[i] == nums2[0]){
                    dp[i][0] = 1;
                    max = 1;
                }
                else
                    dp[i][0] = 0;
            }
            for (int j = 0; j < len2; j++) {
                if(nums1[0] == nums2[j]){
                    dp[0][j] = 1;
                    max = 1;
                }
                else
                    dp[0][j] = 0;
            }

            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if(nums1[i] == nums2[j]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                    else {
                        dp[i][j] = 0;
                    }
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1,2,3,2,1};
        int[] list2 = new int[]{3,2,1,4,7};

        Solution solution = new Solution();
        System.out.println(solution.findLength(list1, list2));
    }
}
