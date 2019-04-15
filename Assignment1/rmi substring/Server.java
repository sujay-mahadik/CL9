import java.net.MalformedURLException;
import java.rmi.*;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        Substring stub = new SubstringImplementation();
        Naming.rebind("subs", stub);

    }
}