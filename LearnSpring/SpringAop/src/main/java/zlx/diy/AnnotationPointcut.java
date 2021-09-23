package zlx.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointcut {
    @Before("execution(* zlx.service.UserServiceimp.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }
    @After("execution(* zlx.service.UserServiceimp.*(..))")
    public  void after(){
        System.out.println("方法执行后");
    }
    @Around("execution(* zlx.service.UserServiceimp.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        System.out.println("签名:" + jp.getSignature()+jp.getArgs());
        //执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");

    }


}
