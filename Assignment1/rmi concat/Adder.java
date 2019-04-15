import java.rmi.*;

public interface Adder extends Remote {
	public String concat(String x, String y) throws RemoteException;
}
