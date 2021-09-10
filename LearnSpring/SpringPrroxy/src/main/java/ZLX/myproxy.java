package ZLX;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class myproxy implements InvocationHandler {
    private Rent rent;
    public void setRent(Rent rent){
        this.rent=rent;
    }
    //生成得到代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    //处理代理实例，并且返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object result=method.invoke(rent,args);
        fare();
        return result;
    }
    public void seeHouse(){
        System.out.println("看房子");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
