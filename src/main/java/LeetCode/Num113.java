package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:06 2021/10/30
 */
public class Num113 {

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

    // 2021.10.30 回溯法
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> list = new ArrayList<>();
            dfs(root, targetSum, list);
            return res;
        }

        public void dfs(TreeNode root, int targetSum, List<Integer> list){
            if(root == null) return;

            list.add(root.val);
            if(root.left==null && root.right==null && list2int(list)==targetSum){
                // 因为是引用传递，所以要新建一个List，不然最后res中的list都是同一个
                List<Integer> copy = new ArrayList<>(list);
                res.add(copy);
                list.remove(list.size()-1);
                return;
            }

            dfs(root.left, targetSum, list);
            dfs(root.right, targetSum, list);
            list.remove(list.size()-1);
        }

        public int list2int(List<Integer> list){
            int len = list.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += list.get(i);
            }
            return sum;
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
        n1.left = n2;n1.right = n3;
        n2.left = n4;
        n3.left = n5;n3.right = n6;
        n4.left = n7;n4.right = n8;
        n6.left = n9;n6.right = n10;

        Solution solution = new Solution();
        List<List<Integer>> list = solution.pathSum(n1, 22);
        for(List<Integer> i : list){
            for(Integer j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
