/**
 * 
 */

/**
 * @author Sujay Mahadik
 *
 */

import java.util.*;
import java.net.*;
import java.io.*;

public class client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {		
		Scanner input = new Scanner(System.in);
		Socket socket = new Socket("localhost", 1245);
		
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		System.out.println("Enter String to Echo");
		String str = input.nextLine();
		outputStream.writeUTF(str);
		
		DataInput inputStream = new DataInputStream(socket.getInputStream());
		System.out.println("Echo from Server: " + inputStream.readUTF());
		
		input.close();
		socket.close();
	}

}
