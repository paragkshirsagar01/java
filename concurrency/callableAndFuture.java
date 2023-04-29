import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class printm{
    public String print(String msg){
        for(int i=0;i<10;i++){
            System.out.println(msg+" "+i);
        }
        return("done "+msg);
    }
}
class conc implements Callable<String>{
    printm p;
    String msg;
    conc(printm p,String msg){
        this.p=p;
        this.msg=msg;
    }
    @Override
    public String call() throws Exception {
        return(p.print(msg));
    }

}
public class callableAndFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService es=Executors.newFixedThreadPool(2);
        printm pm=new printm();
        Future<String> f;
        f=es.submit(new conc(pm,"one"));
        System.out.println(f.get());
        f=es.submit(new conc(pm,"second"));
        System.out.println(f.get());
        es.shutdown();
    }
}
