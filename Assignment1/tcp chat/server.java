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

public class server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException, SocketException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		ServerSocket serverSocket = new ServerSocket(6969);
		Socket socket = serverSocket.accept();
		
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		
		String fromClient = new String();
		
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
		
		while(!fromClient.equals("over")) {
			
			fromClient = inputStream.readUTF();
			System.out.println("Client says: "+ fromClient);
			
			System.out.print("Server Type Message: ");
			outputStream.writeUTF(input.nextLine());
			outputStream.flush();
			
		}
		
		outputStream.close();
		socket.close();
		serverSocket.close();
	}

}
