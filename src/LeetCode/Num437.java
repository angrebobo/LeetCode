package LeetCode;

import java.util.HashMap;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/30 19:15
 */

public class Num437 {

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
        HashMap<Integer, Integer> map = new HashMap<>();
        int target;

        public int pathSum(TreeNode root, int sum) {
            target = sum;
            // 加（0,1）这个元素，是因为路径可能为root节点到叶子结点
            map.put(0,1);

            return recur(root, 0);
        }

        private int recur(TreeNode node, int curSum) {
            if(node == null)
                return 0;

            curSum += node.val;
            int res = 0;
            //这步思路很巧妙
            res = map.getOrDefault(curSum-target, 0);
            //将每个节点的前缀和存到map中
            map.put(curSum, map.getOrDefault(curSum,0)+1);

            int left = recur(node.left, curSum);
            int right = recur(node.right, curSum);

            res += left + right;
            //遍历完当前节点的左右子节点，在map中将当前节点的前缀和减1，因为当前节点的前缀和只对子节点有效
            //这一步不太容易想出来
            map.put(curSum, map.get(curSum)-1);

            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left = n2;
        n2.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;

        Solution solution = new Solution();
        System.out.println(solution.pathSum(n1, 22));
    }
}
