import LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:16 2022/9/8
 */
public class Main {

    public static ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder,
                                                     ArrayList<Integer> inOrder) {
        return buildTree(preOrder,inOrder,0,preOrder.size()-1,0,inOrder.size()-1);
    }

    public static ArrayList<TreeNode> buildTree(ArrayList<Integer> preOrder,
                                                ArrayList<Integer> inOrder, int preStart, int preEnd,
                                                int inStart, int inEnd){

        ArrayList<TreeNode> res=new ArrayList<>();
        if(preStart > preEnd){
            res.add(null);
            return res;
        }
        int rootVal = preOrder.get(preStart);
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i=inStart;i<=inEnd;i++) {
            if(inOrder.get(i) == rootVal){
                candidates.add(i);
            }
        }

        if(candidates.size()!=0){
            for (int i : candidates) {
                int leftTreeSize = i-inStart;
                ArrayList<TreeNode> leftTrees= buildTree(preOrder,inOrder, preStart+1, preStart+leftTreeSize, inStart, i-1);
                ArrayList<TreeNode> rightTrees=buildTree(preOrder,inOrder, preStart+leftTreeSize+1, preEnd, i+1, inEnd);
                for(TreeNode lefTree:leftTrees){
                    for(TreeNode rightTree:rightTrees){
                        TreeNode root=new TreeNode(rootVal);
                        root.left=lefTree;
                        root.right=rightTree;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> preOrder  =new ArrayList<>();
        preOrder.add(1);
        preOrder.add(1);
        preOrder.add(2);

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(1);
        inOrder.add(2);
        inOrder.add(1);

        ArrayList<TreeNode> list1= getBinaryTrees(preOrder, inOrder);
        System.out.println();
    }
}
