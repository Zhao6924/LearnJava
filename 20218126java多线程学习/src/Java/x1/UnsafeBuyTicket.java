package Java.x1;
//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticketStation =new BuyTicket();

        new Thread(ticketStation,"我").start();
        new Thread(ticketStation,"黄牛").start();
        new Thread(ticketStation,"其他人").start();
    }

}
class BuyTicket implements Runnable{
    //票
    private  int ticket=10;
    @Override
    public void run(){
        for (int i=0;i<10;i++) {
            try {
                this.buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //锁的是this
    private synchronized void buy() throws InterruptedException {
        if (ticket<=0)
            return ;
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"买完还剩"+ --this.ticket);
    }

}