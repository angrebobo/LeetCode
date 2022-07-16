package JUC;

import java.util.concurrent.CyclicBarrier;

// 同步屏障  CyclicBarrier
// CyclicBarrier设置了一个屏障值，线程到达屏障时会阻塞，知道最后一个线程达到屏障，所有被屏障拦截的线程会继续运行
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}