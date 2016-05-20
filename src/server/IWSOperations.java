package server;

import java.math.BigInteger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Operations Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface IWSOperations {

	@WebMethod Integer add(Integer arg0, Integer arg1);
	@WebMethod Integer subtract(Integer arg0, Integer arg1);
	@WebMethod Integer mult(Integer arg0, Integer arg1);
	@WebMethod BigInteger lucas(Integer arg0);
	@WebMethod Boolean sleep(Integer ms);

	
}
