import java.rmi.*;
import java.rmi.registry.*;

public class Server {

	public static void main(String[] args) {
		try {
			Adder stub = new AdderImplementation();
			Naming.rebind("concat", stub);
		}
		catch(Exception e) {
			
		}
	}

}
