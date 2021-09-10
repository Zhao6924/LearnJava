package java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zlx.pojo.User;

public class Mytest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        User user=(User)context.getBean("user");
    }
}
