package TestBuildQQ;

public class Student {
    public static void main(String[] args) {
        new Thread(new Sender("localhost",9000,"localhost","学生",7000)).start();
        new Thread(new Receive("老师",7001)).start();
    }
}
