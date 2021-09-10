package ZLX;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class Me {
    public static void main(String[] args) {
        Host host=new Host();
        myproxy proxy =new myproxy();
        proxy.setRent(host);
        Rent proxyRent=(Rent)proxy.getProxy();
        proxyRent.rent();
    }
}
