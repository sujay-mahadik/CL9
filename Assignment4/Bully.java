import java.io.*;
import java.util.*;

public class Bully {
	static int n;
	static int sta[] = new int[100];
	static int pid[] = new int[100];
	static int co;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Processes: ");
		n = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("For Process " + (i+1));
			System.out.print("Status: ");
			sta[i] = input.nextInt();
			
			System.out.print("PID: ");
			pid[i] = input.nextInt();
		}
		
		System.out.println("Which Process will initiate: ");
		int ele = input.nextInt();
		elect(ele);
		System.out.println("Final Coordinator is "+ co);
		
	}
	
	static void elect(int ele) {
		ele = ele - 1;
		co = ele + 1;
		
		for(int i = 0; i < n; i++) {
			if(pid[ele] < pid[i]) {
				System.out.println("Election msg send from "+ (ele + 1) +" to "+ (i + 1));
				if(sta[i] == 1) {
					elect(i+1);
				}
			}
		}
	}

}
