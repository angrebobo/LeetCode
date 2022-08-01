package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:00 2022/6/20
 */
public class Num701 {

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null) return new TreeNode(val);
            TreeNode p = root;
            while (true){
                if(val < p.val){
                    if(p.left != null)
                        p = p.left;
                    else {
                        TreeNode temp = new TreeNode(val);
                        p.left = temp;
                        break;
                    }
                }
                else{
                    if(p.right != null)
                        p = p.right;
                    else {
                        TreeNode temp = new TreeNode(val);
                        p.right = temp;
                        break;
                    }
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {

    }
}
