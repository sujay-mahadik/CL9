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

public class clientCalc {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		Socket socket = new Socket("localhost", 1003);
		
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		
		int num1 = 0, num2 = 0;
		String result = new String();
		
		System.out.print("Enter number 1: ");
		outputStream.writeUTF(input.nextLine());
		outputStream.flush();
		
		System.out.print("Enter number 2: ");
		outputStream.writeUTF(input.nextLine());
		outputStream.flush();
		
		System.out.print("Enter operator(+ - * % ): ");
		outputStream.writeChar(input.next().charAt(0));
		outputStream.flush();
		
		result = inputStream.readUTF();
		System.out.print(result);
		
		outputStream.close();
		socket.close();
	}

}
