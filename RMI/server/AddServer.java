import java.rmi.Naming;

public class AddServer {
    public static void main(String[] args){
        try{
            AddServerImpl addserverimpl=new AddServerImpl();
            Naming.rebind("Addserver", addserverimpl);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
