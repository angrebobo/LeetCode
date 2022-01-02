package leetcode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:27 2021/10/24
 */
public class Num239 {

    // 2021.10.24 方法1
    /*static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int temp_max = findMax(nums, 0, k-1);
            ArrayList<Integer> res_list = new ArrayList<>();

            if(k == len){
                int[] res = new int[1];
                res[0] = temp_max;
                return res;
            }
            else {
                res_list.add(temp_max);

                for (int i = 1; k-1+i < nums.length ; i++) {
                    if(nums[i-1] == temp_max){
                        temp_max = findMax(nums, i, k-1+i);
                    }
                    else {
                        if(nums[k-1+i] > temp_max){
                            temp_max = nums[k-1+i];
                        }
                    }
                    res_list.add(temp_max);
                }

                int[] res = new int[res_list.size()];
                for (int i = 0; i < res_list.size(); i++) {
                    res[i] = res_list.get(i);
                }
                return res;
            }
        }

        *//**
         * @Description 找到nums数组中下标从left到right区间里的最大值
         *//*
        public int findMax(int[] nums, int left, int right){
            int len = right - left + 1;
            if(len > 0){
                if(len == 1) return nums[left];
                else{
                    int max = nums[left];
                    for (int i = left; i <= right; i++) {
                        if(nums[i] > max)
                            max = nums[i];
                    }
                    return max;
                }
            }
            return Integer.MIN_VALUE;
        }
    }*/

    // 2021.10.24 方法2,使用堆排序
    /*static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            PriorityQueue< int[] > queue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                queue.add( new int[]{i, nums[i]} );
            }
            if(k == len){
                int[] res = new int[1];
                res[0] = queue.peek()[1];
                return res;
            }
            else {
                list.add( queue.peek()[1] );
                for (int i = 1; k-1+i < nums.length ; i++) {
                    queue.add( new int[]{k-1+i, nums[k-1+i]} );
                    while (queue.peek()[0] < i){
                        queue.poll();
                    }
                    list.add( queue.peek()[1] );
                }

                int[] res = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    res[i] = list.get(i);
                }
                return res;
            }
        }
    }*/

    // 2021.10.24 方法3,使用单调队列
    /*static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || nums.length < 2) return nums;
            // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
            LinkedList<Integer> queue = new LinkedList();
            // 结果数组
            int[] result = new int[nums.length-k+1];
            // 遍历nums数组
            for(int i = 0;i < nums.length;i++){
                // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
                while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                    queue.pollLast();
                }
                // 添加当前值对应的数组下标
                queue.addLast(i);
                // 判断当前队列中队首的值是否有效
                if(queue.peek() <= i-k){
                    queue.poll();
                }
                // 当窗口长度为k时 保存当前窗口中最大值
                if(i+1 >= k){
                    result[i+1-k] = nums[queue.peek()];
                }
            }
            return result;
        }
    }*/

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k){
            if(nums==null || nums.length<2) return nums;
            int len = nums.length;
            int[] res = new int[len-k+1];
            int index = 0;
            // 双端队列，队列中存放的是数组下标，保证下标对应的值从大到小排列
            LinkedList <Integer> queue = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                    queue.pollLast();
                }
                queue.offerLast(i);

                while (queue.peekFirst() < i-k+1){
                    queue.pollFirst();
                }

                if(i >= k-1){
                    res[index++] = nums[queue.peekFirst()];
                }
            }

            return res;
        }
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,2};
        int k = 2;

        int[] res = solution.maxSlidingWindow(nums, k);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
