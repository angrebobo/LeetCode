package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 13:04 2022/6/25
 */
public class Num165 {
    static class Solution {
        /*public int compareVersion(String version1, String version2) {
            List<Integer> ver1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> ver2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
            if(ver1.size() < ver2.size()){
                for (int i = ver2.size()-ver1.size(); i > 0; i--) {
                    ver1.add(0);
                }
            }
            else if(ver1.size() > ver2.size()){
                for (int i = ver1.size()-ver2.size(); i > 0; i--) {
                    ver2.add(0);
                }
            }

            for (int i = 0; i < ver1.size(); i++) {
                if(ver1.get(i) > ver2.get(i))
                    return 1;
                else if(ver1.get(i) < ver2.get(i))
                    return -1;
            }

            return 0;
        }*/

        public int compareVersion(String version1, String version2){
            String[] ver1 = version1.split("\\.");
            String[] ver2 = version2.split("\\.");
            int len1 = ver1.length;int len2 = ver2.length;
            int i =0, j=0;
            while (i < len1 || j < len2){
                int a = 0, b= 0;
                if(i < len1) a = Integer.parseInt(ver1[i++]);
                if(j < len2) b = Integer.parseInt(ver2[j++]);
                if(a != b) return a>b ? 1 : -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }
}
