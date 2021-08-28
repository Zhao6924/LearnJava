package Java.x1;
//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        new Thread(new BuyTicket(),"我").start();
        new Thread(new BuyTicket(),"黄牛").start();
        new Thread(new BuyTicket(),"其他人").start();
    }

}
class BuyTicket implements Runnable{
    //票
    private  int ticket=10;
    @Override
    public void run(){
        for (int i=0;i<10;i++)
            this.buy();
    }
    private void buy(){
        if (ticket<=0)
            return ;
        System.out.println(Thread.currentThread().getName()+"买完还剩"+this.ticket);
    }

}