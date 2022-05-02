import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description: 树的遍历方法
 * @Data: Created in 9:30 2021/9/26
 */
public class 树的递归遍历及非递归遍历 {

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
     * 递归遍历树。先理解树的递归序，每个节点都有3次回到它自己的机会
     * @param root
     */
    public static void recursion(TreeNode root){
        if(root != null){
//            先序在这里打印
//            System.out.println(root.val);
            recursion(root.left);
//            中序在这里打印
//            System.out.println(root.val);
            recursion(root.right);
//            后序在这里打印
//            System.out.println(root.val);
        }
    }

    /**
     * @Description 先序遍历的非递归实现。用栈。压入栈的顶，将弹出节点的右节点压入，再将弹出节点的左节点压入
     * @param
     * @return
     */
    public static void PreOrder(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val);
                if(root.right != null)
                    stack.push(root.right);
                if(root.left != null)
                    stack.push(root.left);
            }
        }
    }


    /**
     * @Description 中序遍历的非递归实现
     * 先将左孩子节点全都压栈，弹出节点，如果弹出节点有右孩子节点，压栈
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
                p = stack.pop();
                System.out.println(p.val);
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
        InOrder(n1);
        PreOrder(n1);
    }
}
