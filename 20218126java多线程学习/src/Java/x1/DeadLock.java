package Java.x1;
// 这里写的是死锁
public class DeadLock {

}
class LipStick{

}
class Mirror{

}
class Makeup extends  Thread{
    static LipStick lip =new LipStick();
    static  Mirror mir =new Mirror();
    int choice;
    String girlName;
    Makeup(int choice,String girlName)
    {
        this.choice=choice;
        this.girlName=girlName;

    }
    @Override
    public void run(){
        this.makeup();
    }
    private void makeup(){
        if (choice==0)
        {
            synchronized (lip){
                System.out.println(Thread.currentThread().getName()+"获得了lip");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mir){
                    System.out.println(Thread.currentThread().getName()+"获得了mir");
                }

            }

        }
        else
        {
            synchronized (mir){
                System.out.println(Thread.currentThread().getName()+"获得了mir");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lip){
                    System.out.println(Thread.currentThread().getName()+"获得了lip");
                }

            }
        }

    }

    public static void main(String[] args) {
        Makeup girl1=new Makeup(1,"灰姑凉");
        Makeup girl2=new Makeup(0,"白雪公主");
        girl1.start();
        girl2.start();
    }
}
