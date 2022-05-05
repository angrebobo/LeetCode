import java.util.HashSet;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:26 2022/5/5
 */
public class Test {
    public static void dfs(char[] s, int index, HashSet<String> ans){
        if(index == s.length)
            ans.add(String.valueOf(s));

        for (int j = index; j < s.length; j++) {
            swap(s, index, j);
            dfs(s, index+1, ans);
            swap(s, index, j);
        }
    }

    public static void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        HashSet<String> ans = new HashSet<>();
        dfs(s.toCharArray(), 0, ans);
        for(String temp : ans)
            System.out.println(temp);
    }
}
