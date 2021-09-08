import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zlx.pojo.hello;

public class mytest {
    public static void main(String[] args) {
        ApplicationContext con=new ClassPathXmlApplicationContext("beans.xml");
       hello nihao= (hello)con.getBean("hello");
       nihao.toString();
    }
}
