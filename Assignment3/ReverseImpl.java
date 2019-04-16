
import ReverseModule.ReversePOA;

public class ReverseImpl extends ReversePOA {
	ReverseImpl(){
		super();
		System.out.println("Reverse Object Created");
	}
	
	public String reverse_string(String str) {
		StringBuffer strBuff = new StringBuffer(str);
		strBuff.reverse();
		return(("Server sent: "+ strBuff));
	}

}
