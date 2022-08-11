package 笔试题.用友;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:17 2022/8/10
 */
public class Main2 {

    static class Queue{
        int len = 100;
        int[] queue = new int[100];
        int index = -1;

        public Queue() {
        }

        public void add(int val) throws Exception {
            if(index > len){
                throw new Exception("队列已满");
            }
            queue[++index] = val;
        }

        public int poll() throws Exception {
            if(index >= 0){
                int temp = queue[index];
                index--;
                return temp;
            }
            else
                throw new Exception("队列为空");
        }
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        for (int i = 0; i < 105; i++) {
            queue.add(2);
        }
    }
}
