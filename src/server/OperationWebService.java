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
		System.out.println("Computing lucas number of "+arg0+".");
		return internLucas(new BigInteger(arg0.toString()));
	}
	
	private BigInteger internLucas(BigInteger N){
				if( N.equals(BigInteger.ZERO))  return BigInteger.ONE.add(BigInteger.ONE);
			    if( N.equals(BigInteger.ONE))  return BigInteger.ONE;
			    return internLucas(N.subtract(BigInteger.ONE)).add(internLucas(N.subtract(BigInteger.ONE.add(BigInteger.ONE))));
	}

	@Override
	public Boolean sleep(Integer ms) {
		System.out.println("starting to sleep for "+ms+" ms.");
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
