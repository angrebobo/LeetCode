package JUC;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:30 2022/8/29
 */
public class 多线程方法 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                if(i % 20 == 0)
                    Thread.yield();
            }
        };

        new Thread(runnable, "a号").start();
        new Thread(runnable, "b号").start();
    }
}
