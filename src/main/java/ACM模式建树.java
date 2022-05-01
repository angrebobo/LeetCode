import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:19 2022/4/23
 */
public class ACM模式建树 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    //树的存储有两种方式，1是链式存储，2是顺序存储
    //该方法是将数组构建成二叉树
    public static TreeNode buildTree(String[] tree){
        int len = tree.length;
        TreeNode[] treeNodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if("null".equals(tree[i]))
                treeNodes[i] = null;
            else 
                treeNodes[i] = new TreeNode(Integer.parseInt(tree[i]));
        }
        for (int i = 0; i*2+2 < len; i++) {
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[i*2+1];
                treeNodes[i].right = treeNodes[i*2+2];
            }
        }

        return treeNodes[0];
    }

    //将树用数组存储，按照顺序存储的方式
    public static String[] levelOrder(TreeNode root) {
        if (root == null) return null;
        List<String> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null){
                list.add(node.val + "");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else
                list.add("null");
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] tree = new String[]{"4","1","6","0","2","5","7","null","null","null","3","null","null","null","8"};
        TreeNode root = buildTree(tree);
        for(String s : levelOrder(root))
            System.out.printf(s + " ");
    }
}
