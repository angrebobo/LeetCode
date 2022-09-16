import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        List<Integer> p = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p')
                p.add(i);
            else if(s.charAt(i) == 'o')
                o.add(i);
            else if(s.charAt(i) == 'n')
                n.add(i);
            else if(s.charAt(i) == 'y')
                y.add(i);
        }

        int ans = 0;
        int index1=0, index2=0, index3=0, index4 = 0;
        while (index1<p.size() && index2<o.size() && index3<n.size() && index4<y.size()){
            if(p.get(index1)<o.get(index2) && o.get(index2)<n.get(index3) && n.get(index3)<y.get(index4)){
                ans++;
                index1++;
                index2++;
                index3++;
                index4++;
            }
            while (index1<p.size() && index2<o.size() && p.get(index1) > o.get(index2)){
                index2++;
            }
            while (index2<o.size() && index3<n.size() && o.get(index2) > n.get(index3)){
                index3++;
            }
            while (index3<n.size() && index4<y.size() && n.get(index3) > y.get(index4)){
                index4++;
            }
        }
        System.out.println(ans);
    }
}
