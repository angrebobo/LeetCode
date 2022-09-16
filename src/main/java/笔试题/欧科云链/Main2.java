package 笔试题.欧科云链;

public class Main2 {


    public static boolean wordPattern (String pattern, String str) {
        String[] strings = str.split(" ");

        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    if(!strings[i].equals(strings[j]))
                        return false;
                }
                else {
                    if(strings[i].equals(strings[j]))
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
}
