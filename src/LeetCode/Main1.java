package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 *
 * 1,1,2,0,0,4,5
 * /1/2
 * 4,5,0
 * @Data: Created in 20:02 2022/4/20
 */
public class Main1 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode create(int[] nums, int index){
        if(nums.length == 0)
            return null;
        if(index >= nums.length || nums[index] == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = create(nums, index*2);
        root.right = create(nums, index*2+1);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fatherTree;
        String s;
        int[] sonTree;

        String str = sc.next();
        String[] tem1 = str.split(",");
        fatherTree = new int[tem1.length+1];
        for (int i = 0; i < tem1.length; i++) {
            fatherTree[i+1] = Integer.parseInt(tem1[i]);
        }

        sc.nextLine();
        s = sc.nextLine();

        str = sc.next();
        tem1 = str.split(",");
        sonTree = new int[tem1.length+1];
        for (int i = 0; i < tem1.length; i++) {
            sonTree[i+1] = Integer.parseInt(tem1[i]);
        }

        TreeNode father = create(fatherTree,1);
        TreeNode son = create(sonTree,1);
        String[] path = s.split("/");

        int index = 0;
        TreeNode p = father;
        if(path.length > 1){
            while (index != path.length-1){
                if(p.left.val == Integer.parseInt(arr[index]))
                    p = p.left;
                else
                    p = p.right;
                index++;
            }
        }



        p = father;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            if(p.left!=null)
                queue.add(p);
            if(p.right!=null)
                queue.add(p);
        }
        for(TreeNode a : queue){
            System.out.println(a.val);
        }


        /*String[] arr = s.split("/");
        int[] arr_int = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr_int[i] = Integer.parseInt(arr[i]);
        }
        int node_index = 1;
        for (int i = 1; i < arr_int.length; i++) {
            if(fatherTree[node_index*2] == arr_int[i]){
                node_index = node_index*2;
            }
            else if(fatherTree[node_index*2+1] == arr_int[i]){
                node_index = node_index*2+1;
            }
        }*/



    }
}
