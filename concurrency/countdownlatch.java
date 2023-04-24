import java.util.concurrent.CountDownLatch;

class printdemomsg{
    public void printmsg(String msg){
        for(int i=0;i<10;i++){
            System.out.println(msg+" "+i);
        }
    }
} 
class demomulti extends Thread{
    printdemomsg p;
    String msg;
    CountDownLatch cdl;
    demomulti(printdemomsg p,String msg,CountDownLatch cdl){
        this.cdl=cdl;
        this.p=p;
        this.msg=msg;
    }
    @Override
    public void run(){
        this.p.printmsg(msg);
        cdl.countDown();
    }
}
public class countdownlatch {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("countdown latch");
        CountDownLatch cdl=new CountDownLatch(2);
        printdemomsg pd=new printdemomsg();
        demomulti d1=new demomulti(pd,"first",cdl);
        demomulti d2=new demomulti(pd,"second",cdl);
        d1.start();
        d2.start();
        cdl.await();
        System.out.println("end of the program");
    }
}
