package Java.x1;

import java.util.IllegalFormatCodePointException;

//测试线程通信
class TV {
    String show;
    Boolean flag;

    public TV(){
        this.flag=true;
    }
    public synchronized void Show() throws InterruptedException {
        if (flag)this.wait();
       {

            System.out.println("观众正在看" + this.show);
            flag=!flag;
            this.notifyAll();
        }

    }
    public synchronized void play(String show) throws InterruptedException {
        if (!flag)this.wait();
         {
            {

                System.out.println("演员正在录制" + this.show);
                this.notifyAll();

                this.show = show;flag=!flag;
            }
        }

}}
class Player implements Runnable{
    TV tv;
    public  Player(TV tv){
        this.tv=tv;
    }
    @Override
    public void run(){
        for (int i=1;i<10;i++)
        {

            if (i%2==0)
            {
                try {
                    tv.play("快乐大本营");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    tv.play("权力的游戏");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
 class Watcher implements Runnable{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                tv.Show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class TestBool {


    public static void main(String[] args) {
        TV tv=new TV();
       Watcher w1=new Watcher(tv);
       Player p1=new Player(tv);
       
        new Thread(p1).start();
       new Thread(w1).start();

    }


}

