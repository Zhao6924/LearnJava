package Java.x1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(10);
        pool.execute(new Mythread1());
        pool.execute(new Mythread1());
        pool.execute(new Mythread1());
        pool.execute(new Mythread1());

        //关闭
        pool.shutdown();
    }

}
class Mythread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println(Thread.currentThread().getName()+i);

        }
    }
}
