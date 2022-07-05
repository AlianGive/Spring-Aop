package aspect;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class Myaspect2 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
      check();
      Object obj=arg0.proceed();
      log();
      return obj;
    }
    public void check(){
        System.out.println("模拟权限控制");
    }
    public void log(){
        System.out.println("模拟日志");
    }
}
