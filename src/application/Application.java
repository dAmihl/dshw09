package application;

import client.OperationClient;
import server.OperationServer;

/**
 * http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/
 * 
 * @author dAmihl
 *
 */

public class Application {

	private static boolean startAsServer = true;
	public static final String URL = "http://localhost:9999/operations";
	
	public static void main(String[] args) {
		if (args.length < 1){
			startAsServer = true;
		}else{
			switch (args[0].toLowerCase()){
			case "server": startAsServer = true; break;
			case "client": startAsServer = false;break;
			default: startAsServer = true; break;
			}
		}
		
		if (startAsServer){
			System.out.println("Starting as server..");
			new OperationServer().start();
		}else{
			System.out.println("Starting as client..");
			new OperationClient().start();
		}
	}
}
