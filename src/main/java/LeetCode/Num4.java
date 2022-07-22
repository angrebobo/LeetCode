package LeetCode;

import javax.swing.table.TableRowSorter;
import java.lang.reflect.WildcardType;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:59 2022/7/21
 */
public class Num4 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            // 总长度是奇数/偶数
            boolean odd = false;
            int middle = len/2;
            if(len%2 != 0){
                odd  = true;
                middle++;
            }

            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    i++;
                    if(i+j == middle){
                        if(odd) return nums1[i];
                        else {
                            return (nums1[i] + nums1[++i]>nums2[++j]?nums1[i]:nums2[j]) / 2.0;
                        }
                    }
                }
                else {
                    j++;
                    if(i+j == middle){
                        if(odd) return nums2[j];
                        else {
                            return (nums2[j] + nums1[++i]>nums2[++j]?nums1[i]:nums2[j]) / 2.0;
                        }
                    }
                }

            }


        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
