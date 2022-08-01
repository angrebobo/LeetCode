package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 13:10 2022/6/17
 */
public class Num654 {

    static class Solution {
        //方法1，思路来源于中序和后序建立二叉树
        /*public TreeNode constructMaximumBinaryTree(int[] nums) {
            List<Integer> list = new LinkedList<>();
            for(int i : nums)
                list.add(i);

            return buildTree(list);
        }

        public TreeNode buildTree(List<Integer> list){
            if(list.size() == 0)
                return null;

            int index = findMaxIndex(list);
            TreeNode root = new TreeNode(list.get(index));

            root.left = buildTree(list.subList(0, index));
            root.right = buildTree(list.subList(index+1, list.size()));

            return root;
        }

        public int findMaxIndex(List<Integer> list){
            int maxIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) > list.get(maxIndex))
                    maxIndex = i;
            }
            return maxIndex;
        }*/

        //方法2，直接用下标，效率比方法1高很多
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }

        public TreeNode buildTree(int[] nums, int l, int r){
            if(l > r)
                return null;

            int index = findMaxIndex(nums, l, r);
            TreeNode root = new TreeNode(nums[index]);

            root.left = buildTree(nums, l, index-1);
            root.right = buildTree(nums, index+1, r);

            return root;
        }

        public int findMaxIndex(int[] nums, int l, int r){
            int maxIndex = l;
            for (int i = l; i <= r; i++) {
                if(nums[i] > nums[maxIndex])
                    maxIndex = i;
            }
            return maxIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(nums);
    }
}
