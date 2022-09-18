import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:54 2022/9/17
 */
public class Test {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            backTrace(nums, 0, list, set);
            return new ArrayList<>(set);
        }

        public void backTrace(int[] nums, int index, List<Integer> list,
                              Set<List<Integer>> set){
            if(index == nums.length){
                set.add(new ArrayList<>(list));
                return;
            }

            list.add(nums[index]);
            backTrace(nums, index+1, list, set);
            list.remove(list.size()-1);

            backTrace(nums,index+1, list, set);
        }
    }

    public static void main(String[] args) {

    }
}
