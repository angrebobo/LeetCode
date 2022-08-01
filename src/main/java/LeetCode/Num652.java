package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:10 2022/4/2
 */
public class Num652 {

    static class Solution {

        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count(root);
            return result;
        }

        public String count(TreeNode node){
            if(node == null){
                return "#";
            }
            String serial = node.val + "," + count(node.left) + "," + count(node.right);
            map.put(serial, map.getOrDefault(serial, 0) + 1);
            //为什么要map.get(serial)==2，因为题目规定相同的树，返回一次就可以了。如果写成map.get(serial)>1,
            //相同的数在结果中会多次出现
            if(map.get(serial) == 2)
                result.add(node);

            return serial;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;

        Solution solution = new Solution();
        List<TreeNode> res = solution.findDuplicateSubtrees(n1);
        for(TreeNode node : res){
            System.out.println(node.val);
        }
    }
}
