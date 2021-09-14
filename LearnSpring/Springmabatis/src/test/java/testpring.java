import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zlx.mapper.UserMapper;
import zlx.pojo.User;

public class testpring {

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper=context.getBean("userMapper",UserMapper.class);
        for (User user:userMapper.selectUser()){
            System.out.println(user);
        }
    }
}
