import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 使用谷歌的布隆过滤器
 * @Description 布隆过滤器，能够快速检索一个元素是否在一个集合中，查询时间是0(1)，缺点是有一定的误识别率
 * 这篇文章写的不错，可以看看https://segmentfault.com/a/1190000021136424
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        int total = 1000000; // 总数量
        BloomFilter<CharSequence> bf =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);
        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }

        System.out.println("已匹配数量 " + count);
    }
}