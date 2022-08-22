package 笔试题;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:16 2022/8/18
 */
public class Main1 {
    public static boolean check(String s) {
        // 定义左右指针，初始化指向字符串左右两端。
        int left = 0, right = s.length() - 1;
        // 循环直到匹配到中间位置，则跳出循环。
        while (left < right) {
            // 左右指针指向字符不相等，则分别删除两个字符判断剩余子串是否为回文串。
            if (s.charAt(left) != s.charAt(right)) {
                return recursion(s, left + 1, right)
                        || recursion(s, left, right - 1);
            }
            // 左右指针指向字符相等，则移动左右指针继续比较。
            left++;
            right--;
        }
        return true;
    }

    private static boolean recursion(String s, int left, int right) {
        // 找到中间位置。
        int mid = left + (right - left) / 2;
        // 从开头遍历字符串，比较中间位置前后字符串是否对称。
        for (int i = left; i <= mid; i++) {
            // 左边字符距离左边界的距离等于右边字符距离右边界的距离。
            if (s.charAt(i) != s.charAt(right - (i - left))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check(s));
    }
}
