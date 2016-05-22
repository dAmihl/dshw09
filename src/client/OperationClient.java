package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import application.Application;
import server.IWSOperations;

public class OperationClient {

	public void start(){
		URL url;
		try {
			url = new URL(Application.URL+"?wsdl");
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL!");
			e.printStackTrace();
			return;
		}
		
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://server/", "OperationWebServiceService");

        Service service = Service.create(url, qname);

        IWSOperations ops = service.getPort(IWSOperations.class);
        long timeBefore = 0;
        long timeAfter = 0;
        
        System.out.println("Set webservice to sleep for 2 seconds first.");
        ops.sleep(5000);
        System.out.println("Now Adding 1 and 5 on server:");
        timeBefore = System.nanoTime();
        System.out.println(ops.add(1, 5));
        timeAfter = System.nanoTime();
        System.out.println("Time difference: " + (timeAfter - timeBefore) + " nano seconds");
        System.out.println("Now computing lucas number of 10:");
        System.out.println(ops.lucas(10));
        System.out.println("Now multiplay 6 and 7 on server:");
        System.out.println(ops.mult(6, 7));
        System.out.println("Last, but not least, substract 9 from 53:");
        System.out.println(ops.subtract(53, 9));
        System.out.println("------------------------");
        System.out.println("Addition by direct call to a member function:");
        Integer result;
        timeBefore = System.nanoTime();
        result = 1 + 5;
        timeAfter = System.nanoTime();
        System.out.println("Time difference: " + (timeAfter - timeBefore) + " nano seconds");
	}
	
}
