import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AdderImplementation extends UnicastRemoteObject implements Adder {

	protected AdderImplementation() throws RemoteException {
		super();
	}

	public String concat(String x, String y) throws RemoteException {
		return (x+y);
	}

	
}
