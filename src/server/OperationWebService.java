package server;

import java.math.BigInteger;

import javax.jws.WebService;

@WebService(endpointInterface = "server.IWSOperations")
public class OperationWebService implements IWSOperations {

	@Override
	public Integer add(Integer arg0, Integer arg1) {
		System.out.println("Adding "+arg0+" and "+arg1+".");
		return arg0+arg1;
	}

	@Override
	public Integer subtract(Integer arg0, Integer arg1) {
		System.out.println("Subtracting "+arg0+" and "+arg1+".");
		return arg0-arg1;
	}

	@Override
	public Integer mult(Integer arg0, Integer arg1) {
		System.out.println("Multiplicating "+arg0+" and "+arg1+".");
		return arg0*arg1;
	}

	@Override
	public BigInteger lucas(Integer arg0) {
		System.out.println("Lucas number of "+arg0+".");
		return new BigInteger("1");
	}

	@Override
	public Boolean sleep(Integer ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sleep done!");
		return true;
	}

}
