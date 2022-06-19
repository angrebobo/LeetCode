package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:22 2022/6/19
 */
public class Num501 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        static int max;
        static int count;
        static List<Integer> list;
        static int preVal;
        public int[] findMode(TreeNode root) {
            max = 0;
            count = 0;
            list = new LinkedList<>();
            preVal = Integer.MIN_VALUE;
            recrusion(root);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        public void recrusion(TreeNode root){
            if(root != null){
                recrusion(root.left);

                if(preVal == Integer.MIN_VALUE){
                    count = 1;
                }
                else if (preVal == root.val)
                    count++;
                else
                    count = 1;

                if(count == max){
                    list.add(root.val);
                }
                else if(count > max){
                    list.clear();
                    list.add(root.val);
                    max = count;
                }

                preVal = root.val;

                recrusion(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        node.right = node1;
        node1.left = node2;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMode(node)));
    }
}
