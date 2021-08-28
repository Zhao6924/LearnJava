package Java.x1;

import javax.swing.plaf.TableHeaderUI;
import java.util.ConcurrentModificationException;

public class TestPC {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Producer(container).start();
        new Comsumer(container).start();

    }
}
//生产者
 class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container=container;
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}
//消费者
class Comsumer extends Thread{
    SynContainer container;
    public Comsumer(SynContainer container){
        this.container=container;
    }
    @Override
    public  void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id+"只鸡");
        }
    }

}
//产品
class Chicken extends Thread{
    int id;
    public Chicken(int id){
        this.id =id;
    }
}
//缓冲区
class SynContainer{
    Chicken[] chickens=new Chicken[10];
    int count=0;
    public synchronized void push(Chicken product) {
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = product;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        count--;
        Chicken product = chickens[count];
        this.notifyAll();
        return product;
    }
}