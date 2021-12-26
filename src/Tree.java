import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:30 2021/9/26
 */
public class Tree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) {this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description 中序遍历的非递归实现
     * @param
     * @return
     */
    public static void InOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p!=null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }
            else {
                p =  stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    public static void PreOrder(TreeNode root){
         Stack<TreeNode> stack = new Stack<>();
         TreeNode p = root;

         while (p!=null || !stack.isEmpty()){
             if(p != null){
                 System.out.println(p.val);
                 stack.push(p);
                 p = p.left;
             }
             else {
                 p = stack.pop();
                 p = p.right;
             }
         }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;n1.right = n3;
        n3.left = n4;n3.right = n5;
//        InOrder(n1);
        PreOrder(n1);
    }
}
