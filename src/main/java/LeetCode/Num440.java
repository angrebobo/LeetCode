package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解：https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/
 * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/solution/wu-xu-jie-zhu-shi-cha-shu-ye-neng-rong-yi-li-jie-b/
 *
 * @Data: Created in 22:45 2022/7/16
 */
public class Num440 {
    static class Solution {
        /*public int findKthNumber(int n, int k) {
            List<String> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i + "");
            }

            list.sort((o1, o2) -> {
                int len = Math.min(o1.length(), o2.length());
                for (int i = 0; i < len; i++) {
                    if(o1.charAt(i) < o2.charAt(i))
                        return -1;
                    else if(o1.charAt(i) > o2.charAt(i))
                        return 1;
                }
                if(len < o1.length())
                    return 1;
                else if(len < o2.length())
                    return -1;
                else return 0;
            });

            return Integer.parseInt(list.get(k-1));
        }*/

        // 前提知识1：字典序，一个数增加1，和一个数*10，前者的字典序更大
        // 前提知识2：十叉树
        public int findKthNumber(int n, int k) {
            int prefix=1;
            int cur=1;
            while(cur < k){
                int count = get_count(prefix, n);
                // 以prefix开头的数字串太多
                // 更新成prefix*10，即在十叉树中往下了一层
                // prefix更新成prefix*10后，其字典序增加了1
                if(cur+count > k){
                    prefix *= 10;
                    cur++;
                }
                // 以prefix开头的数字串不够
                // prefix加1
                // 其字典序增加cnt
                else if(cur+count <= k){
                    prefix++;
                    cur += count;
                }
            }
            return prefix;
        }

        /**
         * get_count函数的作用是求出，以prefix为前缀的，且不超过n的数字个数
         * 思路就是从位数出发，比如prefix=45， n=4566
         * 先考虑两位数的情况，结果是45,
         * 三位数的情况，结果是450~459
         * 四位数的情况，结果是4500~Math.min(4566，4599)
         */
        public int get_count(int prefix,int n){
            int count=0;
            long cur=prefix, next=prefix+1;
            while (cur <= n){
                // 十叉树中一层的数量
                count += Math.min(n+1, next) - cur;
                cur *= 10;
                next *= 10;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 2042;
        int k = 45;
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(n, k));
//        System.out.println(solution.get_count(1, 12));
    }
}
