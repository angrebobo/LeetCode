package JUC;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 银行流水处理服务类
 * 使用线程池创建 4 个线程，分别计算每个  sheet 里的数据，每个  sheet 计算结果是
 * 1，再由 BankWaterService 线程汇总 4 个 sheet 计算出的结果
 */
public class BankWaterService implements Runnable {
    /**
     * 创建  4 个屏障，处理完之后执行当前类的  run 方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * 假设只有  4 个  sheet，所以只启动  4 个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);
    /**
     * 保存每个  sheet 计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new
            ConcurrentHashMap<>();
    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
// 计算当前  sheet 的银流数据，计算代码省略
                sheetBankWaterCount
                        .put(Thread.currentThread().getName(), 1);
// 银流计算完成，插入一个屏障
                try {
                    c.await();
                } catch (InterruptedException |
                         BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
// 汇总每个  sheet 计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
// 将结果输出
        System.out.println(result);
        sheetBankWaterCount.put("result", result);
    }
    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}
