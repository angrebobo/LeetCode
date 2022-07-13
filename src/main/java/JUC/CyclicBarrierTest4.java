package JUC;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: HuangSiBo
 * @Description:
 * 现在模拟一个常用的场景，一组运动员比赛 1000 米，只有在所有人都准备完成之后，才可以一起开跑（额，先忽略裁判吹口哨的细节）。
 * 定义一个 Runner 类代表运动员，其内部维护一个共有的 CyclicBarrier，每个人都有一个准备时间，准备完成之后，会调用 await 方法，等待其他运动员。当所有人准备都 OK 时，就可以开跑了。
 * @Data: Created in 22:05 2022/7/13
 */
public class CyclicBarrierTest4 {
    static class Runner implements Runnable{

        private CyclicBarrier barrier;
        private String name;

        public Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                //模拟准备耗时
                Thread.sleep(new Random().nextInt(5000));
                System.out.println(name + ":准备OK");
                barrier.await();
                System.out.println(name +": 开跑");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);  //①
        Runner runner1 = new Runner(barrier, "张三");
        Runner runner2 = new Runner(barrier, "李四");
        Runner runner3 = new Runner(barrier, "王五");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);

        service.shutdown();

    }
}

