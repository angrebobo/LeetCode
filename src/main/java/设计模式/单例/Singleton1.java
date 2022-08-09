package 设计模式.单例;

/**
 * @author: HuangSiBo
 * @Description:懒汉式
 * 别人第一次调用时发现实例是空的，赋值后再返回。
 * @Data: Created in 22:32 2022/8/9
 */
public class Singleton1 {
    private Singleton1(){
    }

    private static Singleton1 instance = null;

    /**
     * 线程不安全版本
     * 当A线程进入if(instance == null)代码块后，还没来得及new Singleton1()
     * 线程B也进入了if(instance == null)代码块，就会导致实例化了两个Singleton1对象
     */
    /*public static Singleton1 getSingleton1() {
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }*/



     /**
      * get方法加synchronized,性能略差
      */
    /*public static synchronized Singleton1 getInstance() {
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }*/

     /**
      * 双重检查，加锁
      * 该版本还是有问题，因为指令重排序会导致并发问题
      * 给instance加上volatile，禁止重排序，就能解决问题了
      */
    /*public static Singleton1 getInstance() {
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }*/

     /**
      * 静态内部类的方法
      * JVM保证一个类被加载时是线程互斥的。所以第一次调用getInstance()，instance只被
      * 加载一次并且初始化
      */
     private static class SingletonFactory{
         private static Singleton1 instance = new Singleton1();
     }

    public static Singleton1 getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {

    }
}
