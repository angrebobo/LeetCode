package 笔试题.网易.八月二十;


import java.util.Scanner;

public class Main3 {

    static int goodE;
    static int mod;
    public static int count1(String s){
        goodE = 0;
        mod = Integer.MAX_VALUE;
        StringBuilder builder = new StringBuilder(s);
        dfs(builder, 0, 0);
        return mod;
    }

    public static void dfs(StringBuilder builder, int index, int count){
        if(index == builder.length()){
            int temp = chenk(builder);
            if(temp > goodE){
                goodE = temp;
                mod = count;
            }
            else if(temp == goodE){
                mod = Math.min(mod, count);
            }
            return;
        }

        int c = 0;
        for (int i = 0; i < index; i++) {
            if(builder.charAt(i) == 'e')
                c++;
        }
        if(c + builder.length()-index < goodE)
            return;

        if(builder.charAt(index) == 'r'){
            dfs(builder, index+1, count);

            builder.setCharAt(index, 'd');
            dfs(builder, index+1, count+1);


            builder.setCharAt(index, 'e');
            dfs(builder, index+1, count+1);
            builder.setCharAt(index, 'r');
        }
        else if(builder.charAt(index) == 'd'){
            dfs(builder, index+1, count);

            builder.setCharAt(index, 'r');
            dfs(builder, index+1, count+1);



            builder.setCharAt(index, 'e');
            dfs(builder, index+1, count+1);
            builder.setCharAt(index, 'd');
        }
        else {
            dfs(builder, index+1, count);

            builder.setCharAt(index, 'r');
            dfs(builder, index+1, count+1);



            builder.setCharAt(index, 'd');
            dfs(builder, index+1, count+1);
            builder.setCharAt(index, 'e');
        }
    }

    //统计好e的个数
    public static int chenk(StringBuilder builder){
        int ocunt = 0;
        for (int i = 1; i < builder.length()-1; i++) {
            if(builder.charAt(i) == 'e'){
                if(builder.charAt(i-1)=='r' && builder.charAt(i+1)=='d'){
                    ocunt++;
                }
                else if(builder.charAt(i-1)=='d' && builder.charAt(i+1)=='r'){
                    ocunt++;
                }
            }
        }
        return ocunt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(count1(s));
    }
}
