package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/31 10:51
 */

public class Num572 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        //遍历root，如果有节点的值和subRoot的值相同，那么用isEqual函数判断一下
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null)
                return false;
            if(root.val == subRoot.val){
                boolean temp = isEqual(root, subRoot);
                if(temp)
                    return true;
            }

            boolean left = isSubtree(root.left, subRoot);
            if(left)
                return true;
            boolean right = isSubtree(root.right, subRoot);
            if(right)
                return true;

            return false;
        }


        // 判断root1和root2这两颗树是否相同
        public boolean isEqual(TreeNode root1, TreeNode root2){
            if((root1==null&&root2!=null) || (root1!=null&&root2==null))
                return false;
            if(root1==null && root2==null)
                return true;
            if(root1.val != root2.val)
                return false;

            return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(1);
//        TreeNode n6 = new TreeNode(2);
        n1.left = n2;
//        n2.right = n3;
//        n4.left = n5;
//        n5.right = n6;

        Solution solution = new Solution();
        System.out.println(solution.isSubtree(n1, n3));
    }
}
