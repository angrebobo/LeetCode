package 左神算法;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:14 2022/4/30
 */
public class 四十亿个数找频次最高的数 {
    /**
     * 电脑内存1G，从四十亿个数中找到出现频率最高的数
     * 如果将这个四十亿个数一次读进来，放到表中去处理，肯定会爆内存
     * 思路：将四十亿个数分别存到不同的文件中，比如100个文件中，再分别对每个文件处理，这样就
     * 不会爆内存。
     * 用哈希函数映射并且将结果对100取余，这样能保证每个数都能落到一个文件，并记录数字的出现次数。
     * 然后每次对一个文件进行处理，选出频率最高的，不断更替，遍历完100个文件就能
     * 找到四十亿个数中频次最高的数。
     */
}
