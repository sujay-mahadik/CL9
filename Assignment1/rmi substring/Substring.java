import java.rmi.*;

interface Substring extends Remote {
    public boolean checksubstring(String x, String y) throws RemoteException;
}