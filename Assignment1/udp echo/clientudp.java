/**
 * 
 */

/**
 * @author Sujay Mahadik
 *
 */

import java.net.*;
import java.util.*;
import java.io.*;

public class clientudp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		InetAddress inetAdd = InetAddress.getByName("localhost");
		
		DatagramSocket dsoc = new DatagramSocket();
		
		System.out.println("Enter String to echo");
		String toServer = input.nextLine();
		
		byte arr[] = toServer.getBytes();
		
		DatagramPacket dpack = new DatagramPacket(arr, arr.length, inetAdd, 6565);
		dsoc.send(dpack);
		System.out.println("Echo Sent");
		
		
		dsoc.receive(dpack);
		String fromServer = new String(dpack.getData());
		System.out.println("Echo Received: " + fromServer);
		
	}

}
