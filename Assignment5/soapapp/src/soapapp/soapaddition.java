
package soapapp;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class soapaddition {
	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}
}
