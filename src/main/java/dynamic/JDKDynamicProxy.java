package dynamic;

import aspect.Myaspect;
import dao.TestDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDK动态代理需要实现InvocationHandler接口
public class JDKDynamicProxy implements InvocationHandler {
    private TestDao testDao;
    public Object createProxy(TestDao testDao){
        this.testDao=testDao;
        ClassLoader cld=JDKDynamicProxy.class.getClassLoader();
        Class[] clazz=testDao.getClass().getInterfaces();
        //自动调用invoke方法
        return Proxy.newProxyInstance(cld,clazz,this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Myaspect myaspect=new Myaspect();
        myaspect.before();
        Object obj=method.invoke(testDao,args);
        myaspect.after();
        return obj;
    }
}
