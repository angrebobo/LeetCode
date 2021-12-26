import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/3 13:49
 */

public class Num236 {

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

    /**
     * @Description 2021.10.05写，版本1
     * @param
     * @return
     */
    /*static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            dfs(stack1, root, p);
            dfs(stack2, root, q);

        return lowestCommonAncestorVal(stack1, stack2);
        }

        *//**
         * @Description 将 root节点 到 p节点 路径上的节点全部压入stack中
         * @param
         * @return
         *//*
        public boolean dfs(Stack<TreeNode> stack, TreeNode root, TreeNode p){
            stack.push(root);
            if(root == p) return true;
            boolean isFin = false;
            // 去root的左孩子节点查找
            if(root.left != null)
                isFin = dfs(stack, root.left, p);
            // root的左孩子节点没找到，再去右孩子节点查找
            if(!isFin && root.right!=null)
                isFin = dfs(stack, root.right, p);

            if( !isFin ) stack.pop();

            return isFin;
        }

        *//**
         * @Description 从stack1和stack2中找到最近公共祖先的值
         * @param
         * @return
         *//*
        public TreeNode lowestCommonAncestorVal(Stack<TreeNode> stack1, Stack<TreeNode> stack2){
            List<TreeNode> list1 = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();
            TreeNode res = null;

            // 将stack中的值存入list中
            while ( !stack1.isEmpty() ){
                TreeNode node = stack1.pop();
                list1.add(node);
            }

            while ( !stack2.isEmpty() ){
                TreeNode node = stack2.pop();
                list2.add(node);
            }

            for (TreeNode node1 : list1) {
                for (TreeNode node2 : list2) {
                    if (node1.val == node2.val) {
                        res = node1;
                        return res;
                    }
                }
            }

            return null;
        }
    }*/

    /**
     * @Description 2021.10.05写，版本2
     * @param
     * @return
     */
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> list1 = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();
            dfs(list1, root, p);
            dfs(list2, root, q);

            int lenOflist1 = list1.size();
            int lenOflist2 = list2.size();
            for (int i = lenOflist1-1; i >= 0; i--) {
                for (int j = lenOflist2-1; j >= 0; j--) {
                    if(list1.get(i) == list2.get(j))
                        return list1.get(i);
                }
            }

            return null;
        }

        /**
         * @Description 将 root节点 到 p节点 路径上的节点全部压入stack中
         * @param
         * @return
         */
        public boolean dfs(List<TreeNode> list1, TreeNode root, TreeNode p){
            list1.add(root);
            if(root == p) return true;

            boolean isFin = false;
            // 去root的左孩子节点查找
            if(root.left != null)
                isFin = dfs(list1, root.left, p);
            // root的左孩子节点没找到，再去右孩子节点查找
            if(!isFin && root.right!=null)
                isFin = dfs(list1, root.right, p);

            if( !isFin ) list1.remove(list1.size()-1);

            return isFin;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;node1.right = node3;
        node2.left = node4;node2.right = node5;

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(node1, node2, node5).val);

    }
}
