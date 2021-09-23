import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zlx.service.UserService;

public class mytest {
    public static void main(String[] args) {
        ApplicationContext cotext=new ClassPathXmlApplicationContext("beans.xml");
        UserService service= (UserService) cotext. getBean("userService");
        service.delete();
    }
}
