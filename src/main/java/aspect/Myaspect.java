package aspect;

public class Myaspect {
    public void before(){
        System.out.println("前增强");
    }
    public void after(){
        System.out.println("后增强");
    }
}
