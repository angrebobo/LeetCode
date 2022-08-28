package JUC;

/**
 * @author: HuangSiBo
 * @Description:
 * https://zhuanlan.zhihu.com/p/370130458
 * @Data: Created in 13:45 2022/8/25
 */
public class 三线程轮流打印ABC {
    private int num;
    private static final Object LOCK = new Object();

    private void printABC(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {    //想想这里为什么不能用if代替while，想不起来可以看公众号上一篇文章
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        三线程轮流打印ABC wait_notify_acb = new 三线程轮流打印ABC ();
        new Thread(() -> wait_notify_acb.printABC(0), "A").start();
        new Thread(() -> wait_notify_acb.printABC(1), "B").start();
        new Thread(() -> wait_notify_acb.printABC(2), "C").start();
    }
}
