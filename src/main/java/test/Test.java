package test;

import dao.TestDao;
import dao.TestDaoImpl;
import dynamic.CglibDynamicProxy;
import dynamic.JDKDynamicProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        JDKDynamicProxy jdkProxy=new JDKDynamicProxy();
        TestDao testDao=new TestDaoImpl();
        TestDao testDaoAdvice1=(TestDao)jdkProxy.createProxy(testDao);
        testDaoAdvice1.save();
        testDaoAdvice1.modify();
        testDaoAdvice1.delete();
        System.out.println("===================");
        CglibDynamicProxy cdp=new CglibDynamicProxy();
        TestDao testDaoAdvice2= (TestDao) cdp.createProxy(testDao);
        testDaoAdvice2.save();
        testDaoAdvice2.modify();
        testDaoAdvice2.delete();
        System.out.println("===================");
        ApplicationContext appCon=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        TestDao testDaoAdvice3=(TestDao)appCon.getBean("testDaoProxy");
        testDaoAdvice3.save();
        testDaoAdvice3.modify();
        testDaoAdvice3.delete();
        System.out.println("===================");
        TestDao testDaoAdvice4=(TestDao)appCon.getBean("testDao1");
        testDaoAdvice4.save();
    }
}
