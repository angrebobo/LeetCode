package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/30 22:50
 */

public class Num102 {

     //层序遍历，注意和bfs的区别
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
