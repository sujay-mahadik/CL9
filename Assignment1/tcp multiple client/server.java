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

class server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(3456);
		
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("Connected to: " + socket.toString());
			
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			
			Thread t = new handler(socket, inputStream);
			t.start();
		}
	}

}

class handler extends Thread {
	Socket socket = null;
	DataInputStream inputStream = null;
	
	String toClient =  new String();
	Scanner input = new Scanner(System.in);
	
	public handler (Socket socker, DataInputStream inputStream) {
		this.socket = socket;
		this.inputStream = inputStream;
	}
	
	public void run() {
		try {
			System.out.println("From Client: " + inputStream.readUTF());
			
			
			
		}
		catch (Exception e){
			
		}
		
		try {
			DataOutputStream outputStream = null;
			System.out.print("Send: ");
			outputStream.writeUTF(input.nextLine());
		}
		catch (NullPointerException ioe) {
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
