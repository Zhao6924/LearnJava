package zlxAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestFlection {
    public static void main(String[] args) throws Exception {

        Class<?> c1 = Class.forName("zlxAnnotation.User");

        //获得类的名称
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//类名

        //获得类的属性
        System.out.println("==========================");
        Field[] fields = c1.getFields();//只能找到public 修饰的属性
        for (Field field : fields) {
            System.out.println(field);
        }
        fields = c1.getDeclaredFields();//找到private 修饰的属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获取指定属性的值
        //Field name = c1.getField("name");报错
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("==========================");
        Method[] methods = c1.getMethods();//获取本类及父类的全部public 方法
        for (Method method : methods) {
            System.out.println("getMethods（）："+method);
        }
        System.out.println("==========================");
        methods = c1.getDeclaredMethods();//获取本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods（）："+method);
        }
        System.out.println("==========================");
        //获取指定方法
        Method getName = c1.getMethod("getName");
        System.out.println(getName);

        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);
        System.out.println("==========================");
        //获取指定的构造器
        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("getConstructors"+constructor);
        }
        System.out.println("============================");
        constructors = c1.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("getDeclaredConstructors（）："+constructor);
        }
        System.out.println("======================");



    }
}