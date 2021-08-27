package Java.x1;

class myyeild implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束执行");
    }
}
public class TestYeild {
    public static void main(String[] args) {
        new Thread(new myyeild(),"a").start();
        new Thread(new myyeild(),"b").start();
    }
}
