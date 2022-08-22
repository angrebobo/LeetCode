package 笔试题.网易.八月二十;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String s1 = new StringBuilder(Long.toString(num1)).reverse().toString();
        String s2 = new StringBuilder(Long.toString(num2)).reverse().toString();
        Map<Integer,Integer> cnt1 = new HashMap<>();
        Map<Integer,Integer> cnt2 = new HashMap<>();
        getDDD(s1,0,0,cnt1,0);
        getDDD(s2,0,0,cnt2,0);
        int ans = s1.length()+s2.length()+1;
        for (Integer key1 : cnt1.keySet()) {
            for (Integer key2 : cnt2.keySet()) {
                if(key1%key2 == 0 || key2%key1==0){
                    ans = Math.min(ans,cnt1.get(key1)+cnt2.get(key2));
                }
            }
        }
        System.out.println(ans==(s1.length()+s2.length()+1)?-1:ans);
    }

    public static void getDDD(String str,int p,int val,Map<Integer,Integer> map,int cnt){
        if(str.length()==p){
            if(val!=0){
                map.put(val,str.length()-cnt);
            }
            return;
        }
        //不要当前元素
        getDDD(str,p+1,val,map,cnt);
        //要当前元素
        val += (str.charAt(p)-'0')*(int)Math.pow(10,cnt);
        getDDD(str,p+1,val,map,cnt+1);
    }
}
