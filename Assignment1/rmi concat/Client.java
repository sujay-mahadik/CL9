import java.rmi.*;

public class Client {

	public static void main(String[] args) {
		try {
			String str1 = "MIT";
			String str2 = "WPU";
			
			Adder stub = (Adder)Naming.lookup("concat");
			System.out.println(stub.concat(str1, str2));
		}
		catch(Exception e) {
			
		}

	}

}
