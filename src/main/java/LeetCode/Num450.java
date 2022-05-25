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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (key > root.val)
                root.right = deleteNode(root.right, key); // 去右子树删除
            else if(key < root.val)
                root.left = deleteNode(root.left, key);  // 去左子树删除
            else  {  // 当前节点就是要删除的节点
                if (root.left == null)   return root.right;      // 情况1，欲删除节点无左子
                else if (root.right == null)  return root.left;  // 情况2，欲删除节点无右子
                else {  // 情况3，欲删除节点左右子都有
                    TreeNode node = root.right;
                    while (node.left != null)      // 寻找欲删除节点右子树的最左节点
                        node = node.left;

                    node.left = root.left;     // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                    root = root.right;         // 欲删除节点的右子顶替其位置，节点被删除
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
