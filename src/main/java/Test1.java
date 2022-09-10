import LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:14 2022/9/8
 */
public class Test1 {

    public static ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder,
                                                      ArrayList<Integer> inOrder) {

        ArrayList<TreeNode> list = new ArrayList<>();
        int rootVal = preOrder.get(0);
        int index;
        for (int j = 0; j <= inOrder.size()-1; j++) {
            if(rootVal == inOrder.get(j)){
                index = j;
                TreeNode root = new TreeNode(rootVal);
                int s = index;
                root.left = build(preOrder, 1, s, inOrder, 0, index-1);
                root.right = build(preOrder, s+1, preOrder.size()-1, inOrder, index+1, inOrder.size()-1);
                list.add(root);
            }
        }



        return list;
    }

    public static TreeNode build(ArrayList<Integer> preOrder, int preStart, int preEnd,
                                 ArrayList<Integer> inOrder, int inStart, int inEnd){

        if(preStart > preEnd)
            return null;

        int rootVal = preOrder.get(preStart);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(rootVal == inOrder.get(i)){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int s = index - inStart;
        root.left = build(preOrder, preStart+1, preStart+s, inOrder, inStart, index-1);
        root.right = build(preOrder, preStart+s+1, preEnd, inOrder, index+1, inEnd);
        return root;
    }
}
