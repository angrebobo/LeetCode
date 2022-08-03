package 笔试题.用友;

import java.util.Arrays;

/**
 *
 * 手机英文9键说明如下
 * 1:@!./    2:abc    3:def
 * 4:ghi     5:jkl    6:mno
 * 7:pqrs    8:tuv    9:wxyz
 * 数字键输入第一个字母点击一次，第二个字母连续点击两次，以此类推
 * 统计输入字符串(英文小写，包含英文26个字母和@!./标点符号)，如果通过
 * 手机9键输入，各个数字键的点击次数
 * 输入：abcdtyz@!.
 * 输出：[[1,6],[2,6],[3,1],[8,1],[9,7]]
 */
public class Main {

    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 数字键按从小到大输出
         * @param str string字符串 包含英文26个字母和@!./标点符号的字符串
         * @return int整型二维数组
         */
        public int[][] count (String str) {
            int len = str.length();
            int[][] res = new int[10][2];
            for (int i = 1; i < 10; i++) {
                res[i][0] = i;
            }
            for (int i = 0; i < len; i++) {
                Character character = str.charAt(i);
                switch (character){
                    case '@':
                        res[1][1] += 1;
                        break;
                    case '!':
                        res[1][1] +=2;
                        break;
                    case '.':
                        res[1][1] +=3;
                        break;
                    case '/':
                        res[1][1] +=4;
                        break;
                    case 'a':
                        res[2][1] +=1;
                        break;
                    case 'b':
                        res[2][1] +=2;
                        break;
                    case 'c':
                        res[2][1] +=3;
                        break;
                    case 'd':
                        res[3][1] +=1;
                        break;
                    case 'e':
                        res[3][1] +=2;
                        break;
                    case 'f':
                        res[3][1] +=3;
                        break;
                    case 'g':
                        res[4][1] +=1;
                        break;
                    case 'h':
                        res[4][1] +=2;
                        break;
                    case 'i':
                        res[4][1] +=3;
                        break;
                    case 'j':
                        res[5][1] +=1;
                        break;
                    case 'k':
                        res[5][1] +=2;
                        break;
                    case 'l':
                        res[5][1] +=3;
                        break;
                    case 'm':
                        res[6][1] +=1;
                        break;
                    case 'n':
                        res[6][1] +=2;
                        break;
                    case 'o':
                        res[6][1] +=3;
                        break;
                    case 'p':
                        res[7][1] +=1;
                        break;
                    case 'q':
                        res[7][1] +=2;
                        break;
                    case 'r':
                        res[7][1] +=3;
                        break;
                    case 's':
                        res[7][1] +=4;
                        break;
                    case 't':
                        res[8][1] +=1;
                        break;
                    case 'u':
                        res[8][1] +=2;
                        break;
                    case 'v':
                        res[8][1] +=3;
                        break;
                    case 'w':
                        res[9][1] +=1;
                        break;
                    case 'x':
                        res[9][1] +=2;
                        break;
                    case 'y':
                        res[9][1] +=3;
                        break;
                    case 'z':
                        res[9][1] +=4;
                        break;
                }
            }

            int count = 0;
            for (int i = 1; i < 10; i++) {
                if(res[i][1] != 0)
                    count++;
            }
            int[][] ans = new int[count][2];
            int size = 0;
            for (int i = 1; i < 10; i++) {
                if(res[i][1] != 0){
                    ans[size][0] = res[i][0];
                    ans[size][1] = res[i][1];
                    size++;
                }
            }


            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "abcdtyz@!.";
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.count(s)));
    }
}
