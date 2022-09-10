import java.util.concurrent.CountDownLatch;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:41 2022/9/3
 */
public class Test {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                // 睡眠1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();

        // main线程会阻塞在这里，直到c减为0
        c.await();
        System.out.println("3");
    }
}
