import java.util.concurrent.*;
class printmsg{
    Semaphore s;
    public void printMsg(String msg,Semaphore s) throws InterruptedException{
        s.acquire();
        for(int i=0;i<10;i++)
        System.out.println(msg+" "+i);
        s.release();
    }
}
class multiclass implements Runnable{
    printmsg p;
    String msg;
    Semaphore s;
    multiclass(printmsg p,String msg,Semaphore s){
        this.p=p;
        this.msg=msg;
        this.s=s;
    }
    @Override
    public void run(){
        try {
            p.printMsg(msg,this.s);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
public class concurrency{
    public static void main(String[] args){
        printmsg p=new printmsg();
        Semaphore s=new Semaphore(2);
        Thread t1=new Thread(new multiclass(p,"first",s));
        Thread t2=new Thread(new multiclass(p,"second",s));
        Thread t3=new Thread(new multiclass(p,"third",s));
        t1.start();
        t2.start();
        t3.start();
    }
}