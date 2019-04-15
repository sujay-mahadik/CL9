import java.net.MalformedURLException;
import java.rmi.*;

public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String str1 = "Hello World";
        String str2 = "Wor";

        Substring stub = (Substring) Naming.lookup("subs");
        System.out.println(stub.checksubstring(str1, str2));
    }
}