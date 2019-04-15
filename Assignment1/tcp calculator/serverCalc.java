/**
 * 
 */

/**
 * @author Sujay Mahadik
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class serverCalc {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		ServerSocket serverSocket = new ServerSocket(1003);
		Socket socket = serverSocket.accept();
		
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		
		int num1 = 0, num2  = 0;
		int result;
		
		num1 = Integer.parseInt(inputStream.readUTF());		
		num2 = Integer.parseInt(inputStream.readUTF());
		
		char operator = inputStream.readChar();
		
		System.out.println("Number 1: "+ num1 + " Number 2: " + num2 + " Operator: " + operator);
		
		switch(operator){
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '%':
				result = num1 % num2;
				break;
			default:
				result = 0;
		}
		
		outputStream.writeUTF(String.valueOf(result));
		outputStream.flush();
		
		outputStream.close();
		socket.close();
		serverSocket.close();
	}

}
