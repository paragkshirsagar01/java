interface demoInterface{
    public int calculate(int a, int b);
}
public class functional_interface{
    public static void main(String[] args){
        demoInterface demo=(a,b)->{return a+b;};
        System.out.println(demo.calculate(10, 20));
        demo=(a,b)->{return a*b;};
        System.out.println(demo.calculate(10, 30));
        demo=(a,b)->{return a-b;};
        System.out.println(demo.calculate(10, 30));
    }
}