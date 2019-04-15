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

public class serverudp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DatagramSocket dsoc = new DatagramSocket(6565);
		byte arr1[] = new byte[200];
		
		DatagramPacket dpack = new DatagramPacket(arr1, arr1.length);

		dsoc.receive(dpack);
		String fromClient = new String(dpack.getData());
		System.out.println("From Client: " + fromClient);
		
		dsoc.send(dpack);
		System.out.println("Echo Sent Back");

	}

}
