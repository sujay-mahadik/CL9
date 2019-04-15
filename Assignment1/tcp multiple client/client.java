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
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		Socket socket = new Socket("localhost", 3456);
		
		DataOutput outputStream = new DataOutputStream(socket.getOutputStream());
		DataInput inputStream = new DataInputStream(socket.getInputStream());
		
		
		System.out.print("You Say: ");
		outputStream.writeUTF(input.nextLine());
		
		System.out.println("Reply: " + inputStream.readUTF());
		
		socket.close();
	}

}
