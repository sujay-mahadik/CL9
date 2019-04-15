/**
 * 
 */

/**
 * @author Sujay Mahadik
 *
 */
import java.net.*;
import java.io.*;

public class server extends Thread {

	private ServerSocket serverSocket;
	
	public server() throws IOException {
		serverSocket = new ServerSocket(1245);
		System.out.println();
	}
	
	public void run() {
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				String fromClient = inputStream.readUTF();
				System.out.println("Client: " + socket.getRemoteSocketAddress() + " Echo: "+ fromClient);
				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				
				outputStream.writeUTF(fromClient);
				
				socket.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		System.out.println("Server Ready");
		
		try {
			
			Thread t = new server();
			t.run();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
