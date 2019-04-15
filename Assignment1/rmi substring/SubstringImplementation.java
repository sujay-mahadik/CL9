import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class SubstringImplementation extends UnicastRemoteObject implements Substring {
    public SubstringImplementation() throws RemoteException {
        super();
    }

    public boolean checksubstring(String x, String y) throws RemoteException {

        boolean b = x.contains(y);
        return b;
    }
}