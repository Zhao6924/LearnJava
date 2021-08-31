package zlxAnnotation;

import java.util.List;
import java.util.Map;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Test11 {

    public void test01(Map<String, User> map, List<User> list) {

    }

    public Map<String, User> test02() {
        return null;
    }

    public static void main(String[] args) throws Exception {

        Class<Test11> c1 = Test11.class;

        Method test01 = c1.getMethod("test01", Map.class, List.class);
        //获取参数的泛型参数类型
        Type[] genericParameterTypes = test01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            //判断这个泛型是不是参数化类型
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        System.out.println("===================================================================");
        Method method = c1.getMethod("test02");

        Type type = method.getGenericReturnType();
        if (type instanceof  ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

    }
}