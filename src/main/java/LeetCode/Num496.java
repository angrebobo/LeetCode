package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:59 2022/6/6
 */
public class Num496 {
    static class Solution {
        //方法1，stack存储元素下标
        /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            Arrays.fill(res, -1);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], i);
            }

            //维持一个从栈顶到栈底从小到大的栈。stack存储nums2元素的下标
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i < nums2.length; i++) {
                //当一个更大的元素进栈时，要把栈里比入栈元素小的元素全部弹出，所以要用while
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    if(map.containsKey(nums2[stack.peek()])){
                        int index = map.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }

                stack.push(i);
            }

            return res;
        }
    }*/

        //方法2，stack存储元素值
        public int[] nextGreaterElement(int[] nums1, int[] nums2){
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(nums2[0]);
            for (int i = 1; i < nums2.length; i++) {
                while (!stack.isEmpty() && stack.peek()<nums2[i]){
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }

        //方法3，我自己改的。每当nums1中有元素找到比它大的元素，记录个数，在遍历nums2时，如果nums1中所有元素
        //已经都找到，终止循环。
        /*public int[] nextGreaterElement(int[] nums1, int[] nums2){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], -1);
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(nums2[0]);
            int count = 0;
            for (int i = 1; i < nums2.length; i++) {
                if(count == nums1.length)
                    break;
                while (!stack.isEmpty() && stack.peek()<nums2[i]){
                    if(map.containsKey(stack.peek())){
                        map.put(stack.peek(), nums2[i]);
                        count++;
                    }
                    stack.pop();
                }
                stack.push(nums2[i]);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }*/
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    }
}
