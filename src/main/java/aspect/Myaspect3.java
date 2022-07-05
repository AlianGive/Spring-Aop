package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect3 {
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
    System.out.println("环绕开始");
    Object obj=pjp.proceed();
    System.out.println("环绕结束");
    return obj;
    }
}
