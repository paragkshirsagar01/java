import java.util.concurrent.Phaser;

class printdem{
    public void printmsg(String msg){
        System.out.println(msg);
    }
}
class multidemo implements Runnable{
    Phaser p;
    printdem pd;
    String msg;
    multidemo(Phaser p,printdem pd,String msg){
        this.p=p;
        this.pd=pd;
        this.msg=msg;
        p.register();
    }

    @Override
    public void run() {
        pd.printmsg(msg);
        p.arriveAndDeregister();
    }

}
public class phasedemo {
    public static void main(String[] args){
        Phaser p=new Phaser(1);
        System.out.println("starting");
        printdem pd=new printdem();
        Thread t1=new Thread(new multidemo(p,pd,"one"));
        Thread t2=new Thread(new multidemo(p,pd,"second"));
        t1.start();
        t2.start();
        p.arriveAndAwaitAdvance();

        System.out.println("ending");
        p.arriveAndDeregister();//deregistering main thread
    }
}
