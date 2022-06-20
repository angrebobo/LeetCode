package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:08 2022/5/24
 */
public class Num450 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        /*public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return root;

            TreeNode p = root;
            while (true){
                if(key < p.val)
                    p = p.left;
                else if(key > p.val)
                    p = p.right;
                else {
                    break;
                }
            }

            if(p.left == null) return p.right;
            else if(p.right == null) return p.left;
            else {
                TreeNode pre = p;
                TreeNode node = p.left;
                while (node.left != null){
                    pre = pre.left;
                    node = node.left;
                }
                p.val = node.val;
                pre.left = null;
                return root;
            }
        }*/

        //要删除节点为p，把p的左子树放到p的右子树最左边节点的左子树上
        public TreeNode deleteNode(TreeNode root, int key){
            if(root == null) return null;

            if(key < root.val)
                root.left = deleteNode(root.left, key);
            else if(key > root.val)
                root.right = deleteNode(root.right, key);
            else {
                if(root.left == null)
                    return root.right;
                else if(root.right == null)
                    return root.left;
                else {
                    TreeNode node = root.right;
                    while (node.left != null)
                        node = node.left;

                    node.left = root.left;
                    root = root.right;
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;n1.right = n3;
        n2.right = n4;
        n3.right = n5;

        Solution solution = new Solution();
        solution.deleteNode(n1, 6);
    }
}
