/**
 * @author: HuangSiBo
 * @Description: 前缀树
 * @Data: Created in 15:52 2022/4/17
 */
public class TireTree {

    public class TireNode{
        int pass;
        int end;
        TireNode[] next;
        public TireNode() {
            this.pass = 0;
            this.end = 0;
            //next[0] == null，表示没有走向'a'的路
            //next[25] != null，表示有走向'z'的路
            this.next = new TireNode[26];
            //不是一定要用数组，如果字符种类较多，
            // 可以用HashMap<Character, TireNode>
        }
    }

    private TireNode root;

    public TireTree() {
        root = new TireNode();
    }

    /**
     * 插入字符串到前缀树中
     * @param s
     */
    public void insert(String s){
        if(s == null)
            return;
        char[] chs = s.toCharArray();
        TireNode node = root;
        node.pass++;

        int index;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if(node.next[index] == null){
                node.next[index] = new TireNode();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 将字符串从前缀树中删掉
     * @param s
     */
    public void delete(String s){
        if(serach(s) != 0){
            char[] chs = s.toCharArray();
            TireNode node = root;
            node.pass--;

            int index;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                //如果这个node的pass变为0，表示这个节点被删光了，需要从前缀树中删去
                if(--node.next[index].pass == 0){
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end--;
        }
    }


    /**
     * 查询一个字符串之前加过几次
     * @param s
     * @return
     */
    public int serach(String s){
        if(s == null)
            return 0;
        char[] chs = s.toCharArray();
        TireNode node = root;
        int index;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if(node.next[index] == null){
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    /**
     * 所有已加入的字符串，有几个是以pre字符串作为前缀的
     * @param pre
     * @return
     */
    public int predixNum(String pre){
        if(pre == null)
            return 0;
        char[] chs = pre.toCharArray();
        TireNode node = root;
        int index;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if(node.next[index] == null){
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }


    public static void main(String[] args) {
        String[] s = new String[]{"abc", "abd", "abe", "abe"};
        TireTree tireTree = new TireTree();
        for (int i = 0; i < s.length; i++) {
            tireTree.insert(s[i]);
        }
        System.out.println(tireTree.serach("abe"));
        System.out.println(tireTree.predixNum("a"));
    }
}
