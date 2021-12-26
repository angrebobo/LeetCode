import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:20 2021/5/24
 */
public class Num199 {

     static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    /* //解法1，把每层的元素都放到一个List中，最后把每个List的最后面的元素取出集合
    public static List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> path = new LinkedList<>();
        if(root == null) return new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n;

        while (!queue.isEmpty()){
            n = queue.size();
            List<Integer> floor = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                TreeNode node = queue.poll();
                floor.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            path.add(floor);
        }

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < path.size(); i++) {
            ans.add(path.get(i).get(path.get(i).size()-1));
        }
        return ans;
    }*/

    //解法2，只取每层最右边的元素
    public static List<Integer> rightSideView(TreeNode root){
        if(root == null) return new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n;

        while (!queue.isEmpty()){
            n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode node = queue.poll();
                if(i == n)
                    ans.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;
        System.out.println(rightSideView(n1));
    }
}
