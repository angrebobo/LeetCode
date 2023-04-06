package 魔法屋.单例模式;

/**
 * @author: HuangSiBo
 * @Description: 饿汉式。
 * 别人第一次获取对象时，已经存在这个类对象了，省去了创建对象的开销
 * @Data: Created in 22:27 2022/8/9
 */
public class Singleton {
    // 创建一个实例对象
    private static Singleton instance = new Singleton();

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton() {
    }

    /**
     * 静态get方法
     */
    public static Singleton getSingleton() {
        return instance;
    }
}
