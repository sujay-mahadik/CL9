import ReverseModule.*;

import org.omg.*;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ReverseServer {

	public static void main(String[] args) {
		try {
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			ReverseImpl rvr = new ReverseImpl();
			org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
			
			System.out.println("Step 1");
			
			Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);
			
			System.out.println("Step 2");
			
			org.omg.CORBA.Object ObjectRef = orb.resolve_initial_references("NameService");
			
			System.out.println("Step 3");
			
			NamingContextExt ncRef = NamingContextExtHelper.narrow(ObjectRef);
			
			System.out.println("Step 4");
			String name = "Reverse";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, h_ref);
			
			System.out.println("Reverse String Reading and Writing");
			orb.run();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
