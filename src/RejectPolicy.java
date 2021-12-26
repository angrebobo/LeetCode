import java.util.concurrent.*;

/**
 * @author linsanity
 * @date 2021-07-07 17:21
 * @desc
 */
class MyTask implements Runnable {
    private String id;

    public MyTask(String id) {
        this.id = id;
    }

    public void run() {
        System.out.println(id+"线程名"+Thread.currentThread().getName());
    }
}

public class RejectPolicy {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            ExecutorService es = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.CallerRunsPolicy());
            MyTask t1 = new MyTask("id:1");
            MyTask t2 = new MyTask("id:2");
            MyTask t3 = new MyTask("id:3");
            MyTask t4 = new MyTask("id:4");
            MyTask t5 = new MyTask("id:5");
            MyTask t6 = new MyTask("id:6");
            MyTask t7 = new MyTask("id:7");

            es.execute(t1);
            es.execute(t2);
            es.execute(t3);
            es.execute(t4);
            es.execute(t5);
            es.execute(t6);
            es.execute(t7);

            // 监控线程池,每个1ms打印一次，打印10次记录
            ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);
            int i = 0;
            while (i < 10) {
                System.out.println();

                int queueSize = tpe.getQueue().size();
                System.out.println("当前排队线程数：" + queueSize);

                int activeCount = tpe.getActiveCount();
                System.out.println("当前活动线程数：" + activeCount);

                long completedTaskCount = tpe.getCompletedTaskCount();
                System.out.println("执行完成线程数：" + completedTaskCount);

                long taskCount = tpe.getTaskCount();
                System.out.println("总线程数：" + taskCount);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        System.out.println("new Thread得到的线程名:"+thread.getName());
        thread.start();

    }
}
