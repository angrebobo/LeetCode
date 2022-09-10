import LeetCode.TreeNode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:41 2022/9/3
 */
public class Test {

    public static TreeNode constructFromPrePost(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        // 注意递归结束的条件
        // 当前节点如果是叶子节点，那preStart==preEnd
        // 叶子节点在创建左右子节点时，preStart > preEnd， return null
        if(preStart > preEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int leftTreeSize = rootIndex - inStart;

        root.left = build(preorder, preStart+1, preStart+leftTreeSize, inorder, inStart, rootIndex-1);

        root.right = build(preorder, preStart+leftTreeSize+1, preEnd, inorder, rootIndex+1, inEnd);

        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder =  new int[]{9,3,15,20,7};
        TreeNode node = constructFromPrePost(preorder, inorder);
        System.out.println(node.val);
    }
}
