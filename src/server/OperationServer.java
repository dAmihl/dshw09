package server;

import javax.xml.ws.Endpoint;

import application.Application;

public class OperationServer {

	public void start(){
		Endpoint.publish(Application.URL, new OperationWebService());
	}
	
}
