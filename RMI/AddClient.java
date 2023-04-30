import java.rmi.*;
public class AddClient {
    public static void main(String[] args){
        try{
            String addserverurl="rmi://127.0.0.1/Addserver";
            AddserverIntf addServerIntf=(AddserverIntf)Naming.lookup(addserverurl);
            System.out.println(addServerIntf.add(10, 20));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
