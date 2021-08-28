package Java.x1;
public class UnsafeBank {

    public static void main(String[] args) {
        //账户
        Account account=new Account(100,"结婚基金");
        Drawing you=new Drawing(account,100,"你");
        Drawing girlf=new Drawing(account,50,"女朋友");

        you.start();
        girlf.start();

    }
}
class Account{
    int monney;
    String name;
    public Account(int monney,String name)
    {
        this.monney=monney;
        this.name=name;
    }
};
class Drawing extends Thread{
    Account account;
    //收了多少钱
    int drawMoney;
    //现在手里有多少钱
    int nowMoney;
    public  Drawing(Account count,int drawingMoney,String name)
    {
        super(name);
        this.account=count;
        this.drawMoney=drawingMoney;
       // this.nowMoney=nowMoney;
    }

/*   @Override
    public void run(){
        if (account.monney-this.drawMoney<0)
        {
            System.out.println(Thread.currentThread().getName()+"取不了，钱不够");
            return ;
        }
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       account.monney=account.monney-drawMoney;
        nowMoney=nowMoney+drawMoney;
        //手上剩下的钱
       System.out.println(Thread.currentThread().getName()+"余额"+this.nowMoney);
       //账户的余度
       System.out.println(Thread.currentThread().getName()+"账户额度"+this.account.monney);
   }*/
@Override
public synchronized void run() {
    synchronized (account) {
        if (account.monney - this.drawMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "取不了，钱不够");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.monney = account.monney - drawMoney;
        nowMoney = nowMoney + drawMoney;
        //手上剩下的钱
        System.out.println(Thread.currentThread().getName() + "余额" + this.nowMoney);
        //账户的余度
        System.out.println(Thread.currentThread().getName() + "账户额度" + this.account.monney);
    }
}
}