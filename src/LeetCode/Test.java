package LeetCode;


import java.nio.IntBuffer;

/**
 * @Description TODO
 * @Author HuangSiBo
 * @Date 2022/2/13 18:25
 **/
public class Test {

    public static void main(String[] args) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        for(StackTraceElement stackTraceElement : stack){
            System.out.println(stackTraceElement);
        }
    }
}


