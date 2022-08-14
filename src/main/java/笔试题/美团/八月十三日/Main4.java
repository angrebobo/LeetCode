package 笔试题.美团.八月十三日;

import java.util.*;

/**
 * 三元组，求数组中有几个三元组满足，i<j<k, nums[i] - num[j] = 2num[j] - num[k]
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Set<List<Integer>> set = new HashSet<>();
        int i = 0, k = 0, j = 0;
        for(;i<n;i++){
            for(j=i+1; j<n; j++){
                for(k=j+1; k<n; k++){
                    if(nums[i]+nums[k] == 3*nums[j]){
                        List<Integer> list = new ArrayList<>();
                        list.add(i+1);
                        list.add(j+1);
                        list.add(k+1);
                        set.add(list);
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}
