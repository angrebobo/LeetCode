package JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 18:48 2022/7/13
 */
public class CountDownLatchTest1 {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println("3");
    }
}
