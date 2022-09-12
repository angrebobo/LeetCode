package 笔试题.华为.八月三十一;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：字符串压缩
 * 题目描述：给定一段英文句子和一个英文单词列表。英文句子包含英文单词和标点符号，其中:
 * 英文单词只包含[a-zA-Z]范围内的字符;
 * 标点符号包括逗号、句号、双引号(双引号两边至少有一个空格)。
 * 如果列表中有单词在句子中存在(大小写不敏感)且该单词未被双引号包含，
 * 则使用该单词在列表中的索引值(索引值从0开始)代替句子中的该单词，
 * 如果英文单词列表中存在重复的英文单词，则以该单词最后一次出现的索引值进行替换。
 *
 * 输入描述：第一行：一段英文句子
 * 第二行：英文单词列表
 * 提示:每个英文单词长度在[150]范围内。
 * 输入的英文句子长度在[0,10000]范围内。
 * 输入的英文单词列表长度在[0,100000]范围内。
 * 英文句子中不会出现双引号不匹配的情况。
 * Hello world.
 * Good Hello LOOP
 * 解释: hello在英文句子中存在，则使用hello的索引值进行替换
 * 输出描述：替换后的英文句子
 * 1 world.
 *
 * hello world, "dsa" maybe you.
 * world dsa you
 *
 * hello 0, "dsa" maybe 2.
 *
 * @Data: Created in 10:57 2022/9/12
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();


        String[] sentence = s1.split(" ");
        String[] words = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i].toUpperCase(), i);
        }

        for (int i = 0; i < sentence.length; i++) {
            String temp = sentence[i].toUpperCase();
            String symbol = "";
            if(temp.charAt(0) != '"'){
                if(temp.charAt(temp.length()-1) == '.' || temp.charAt(temp.length()-1) == ','){
                    symbol = temp.substring(temp.length()-1);
                    temp = temp.substring(0, temp.length()-1);
                }

                if( map.containsKey(temp) ){
                    sentence[i] = map.get(temp) + symbol;
                }
            }
        }
        String join = String.join(" ", sentence);
        System.out.println(join);
    }
}
