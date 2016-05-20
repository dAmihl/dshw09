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
        System.out.println("Set webservice to sleep for 2 seconds first.");
        ops.sleep(5000);
        System.out.println("Now Adding 1 and 5 on server: ");
        System.out.println(ops.add(1, 5));
        System.out.println("Now computing lucas number of 10:");
        System.out.println(ops.lucas(10));
	}
	
}
