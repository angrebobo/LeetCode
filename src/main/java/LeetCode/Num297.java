package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:00 2022/4/3
 */
public class Num297 {

    public static class Codec {

        // 将一棵树序列化成字符串
        public String serialize(TreeNode root){
            if(root == null)
                return "#";

            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        // 将字符串反序列化成一棵树
        public TreeNode deserialize(String data) {
           String[] temp = data.split(",");
           Queue<String> queue = new LinkedList<>(Arrays.asList(temp));
           return buildTree(queue);
        }

        public TreeNode buildTree(Queue<String> queue){
            String s = queue.poll();
            if("#".equals( s )){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left=n2;n1.right=n3;
        n3.left=n4;n3.right=n5;

        Codec codec = new Codec();
        System.out.println(codec.serialize(n1));
       //TreeNode temp = codec.deserialize( codec.serialize(n1) );
    }
}
