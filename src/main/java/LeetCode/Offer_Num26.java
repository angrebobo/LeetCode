package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:30 2022/4/26
 */
public class Offer_Num26 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A==null || B==null)
                return false;

            return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean isSub(TreeNode A, TreeNode B){
            if(B == null)
                return true;
            if(A == null || A.val != B.val)
                return false;

            return isSub(A.left, B.left) && isSub(A.right, B.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(1);
        n6.left = n7;

        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(n1, n6));
    }
}
