/**
 * 
 */

/**
 * @author Sujay Mahadik
 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner input = new Scanner(System.in);

		DataOutputStream outputStream = null;
		DataInputStream inputStream = null;
		
		Socket socket = new Socket("localhost", 6969);
		
		String fromServer = new String();
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		inputStream = new DataInputStream(socket.getInputStream());
		
		while(!fromServer.equals("over")) {
			System.out.print("Client Type Message: ");
			outputStream.writeUTF(input.nextLine());
			outputStream.flush();
			
			fromServer = inputStream.readUTF();
			System.out.println("Server Says: "+fromServer);			
		}
		
		socket.close();
	}

}
