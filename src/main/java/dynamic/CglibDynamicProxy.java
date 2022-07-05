package dynamic;

import aspect.Myaspect;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {
    public Object createProxy(Object target){
        //创建一个动态类对象，即增强对象
        Enhancer enhancer=new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法
        enhancer.setCallback((Callback) this);
        //创建代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Myaspect myaspect=new Myaspect();
        myaspect.before();
        Object obj=methodProxy.invokeSuper(proxy,args);
        myaspect.after();
        return obj;
    }
}
