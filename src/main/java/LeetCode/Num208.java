package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:14 2022/4/17
 */
public class Num208 {
     class Trie {
         class TireNode{
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

        public Trie() {
            root = new TireNode();
        }

        /**
         * 插入字符串到前缀树中
         * @param word
         */
        public void insert(String word){
            if(word == null)
                return;
            char[] chs = word.toCharArray();
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
         *
         * @param s
         */
        public void delete(String s){
            if(!search(s)){
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
         * @param word
         * @return
         */
        public boolean search(String word){
            if(word == null)
                return false;
            char[] chs = word.toCharArray();
            TireNode node = root;
            int index;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.next[index] == null){
                    return false;
                }
                node = node.next[index];
            }

            return node.end != 0;
        }


        public boolean startsWith(String prefix){
            if(prefix == null)
                return false;
            char[] chs = prefix.toCharArray();
            TireNode node = root;
            int index;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.next[index] == null){
                    return false;
                }
                node = node.next[index];
            }
            return true;
        }
    }
}
