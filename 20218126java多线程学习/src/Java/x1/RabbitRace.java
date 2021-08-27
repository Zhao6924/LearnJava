package Java.x1;
class race implements Runnable{
    private static String winner=null;
    private static int meters=0;
    @Override
    public void run() {
       for (int i=0;i<=100;i++)
       {
           if (GameOver(i))
               break;

           System.out.println(Thread.currentThread().getName()+"跑了多少米"+i+"米");
           this.meters+=1;
           if(Thread.currentThread().getName().equals("兔子")&& i>90) {
               try {
                   Thread.sleep(20);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }


       }
    }
    private boolean GameOver(int i)
    {
        if (this.winner!=null)
            return true;
       if (i==100)
       {
           this.winner=Thread.currentThread().getName();
           System.out.println("winner is"+this.winner);
           return true;
       }
       else
       {
           return false;
       }

    }
}
public class RabbitRace {
    public static void main(String[] args) {
        new Thread(new race(),"兔子").start();
        new Thread(new race(),"乌龟").start();
    }
}
