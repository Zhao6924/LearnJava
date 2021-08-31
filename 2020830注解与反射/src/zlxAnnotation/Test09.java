package zlxAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Test09 {
    public static void main(String[] args) throws Exception {

        //获得Class对象
        Class<?> c1 = Class.forName("cn.bloghut.reflection.User");
        //构造一个对象
        //User user = (User)c1.newInstance();//本质上是调用了类的无参构造器
        // System.out.println(user);

        // Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);

        //User user2 = (User)constructor.newInstance("闲言", 1, 18);
        //System.out.println(user2);

        //通过反射调用普通方法
        User user = (User)c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke ： 激活的意思
        setName.invoke(user,"zlx");
        System.out.println(user.getName());

        //通过反射操作属性
        User c4 = (User)c1.newInstance();
        Field field = c1.getDeclaredField("name");
        //关掉检查
        //反射不同直接操作私有属性，需要关闭安全简则，属性或方法的setAccessible
        field.setAccessible(true);
        field.set(c4,"反射设置属性");
        System.out.println(c4);
    }
}