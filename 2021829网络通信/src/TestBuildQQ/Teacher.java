package TestBuildQQ;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new Sender("localhost",7001,"localhost","老师",9001)).start();
        new Thread(new Receive("学生",9000)).start();
    }
}
