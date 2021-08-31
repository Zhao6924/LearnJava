package zlxAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class testAnnotation
{
    @MyAnntation(age=18,name="zlx", value = "")
    public void  test1(){

    }
    @MyAnntation("zha")
    public void test(){

    }
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnntation{
    //注解参数
    String name() default "0";
    int age() default 0;
    int id() default -1;
    String value();
    String[] school()default {"吉首大学","桂林电子科技大学"};
}