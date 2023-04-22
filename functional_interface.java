interface demoInterface{
    public int calculate(int a, int b);
}
//generic functional interface

interface demoInterface2<T>{
    T func(T t);
}
class democlass{
    public static int add(int a,int b){
        return a+b;
    }
}
public class functional_interface{
    //method reference
    public static int func(demoInterface d,int a,int b){
        return d.calculate(a, b);
    }
    public static void main(String[] args){
        demoInterface demo=(a,b)->{return a+b;};
        System.out.println(demo.calculate(10, 20));
        demo=(a,b)->{return a*b;};
        System.out.println(demo.calculate(10, 30));
        demo=(a,b)->{return a-b;};
        System.out.println(demo.calculate(10, 30));
        demo=(a,b)->{return a/b;};
        System.out.println(demo.calculate(10, 30));

        demoInterface2<String> demo2=(str)->{
            StringBuffer sb=new StringBuffer(str);
            return String.valueOf(sb.reverse());
        };

        System.out.println(demo2.func("parag"));
        System.out.println("method reference" + func(democlass::add, 10, 20));
    }
}