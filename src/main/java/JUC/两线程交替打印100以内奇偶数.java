package JUC;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 13:46 2022/8/25
 */
public class 两线程交替打印100以内奇偶数 {

    private static final Object Lock = new Object();
    private volatile int num = 1;

    public void print() {
        synchronized (Lock){
            while (num <= 10){
                try {
                    System.out.println(Thread.currentThread().getName() + ":  " + num++);
                    Lock.notifyAll();
                    Lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        两线程交替打印100以内奇偶数 a = new 两线程交替打印100以内奇偶数();
        new Thread(()->a.print(), "odd").start();
        Thread.sleep(10);
        new Thread(()->a.print(), "even").start();
    }
}
