/**
 * @author Kyle Hauslaib
 * @version 1.0 [26.08.2018]
 * 
 * This class pings a specified server and returns boolean true if the server is reachable, false if unreachable.
 *
 */
import java.net.*;
import java.io.*;
public class ServerPing {

	/**
	 * 
	 */
	public ServerPing() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean pingServer (String server, int port, int timeout) throws IOException{
		boolean result = false;
		
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(server, port), timeout);
		socket.close();
		result = true;


		return result;
	}
	
	public boolean pingIPAddress (String ip, int port, int timeout) throws IOException{
		boolean result = false;
		
		InetAddress address = InetAddress.getByName(ip);
		// System.out.println(address.getHostName());
		if (pingServer (address.getHostName(), port, timeout))
			result=true;

		return result;
	}
	
	public boolean checkConnectivity () throws IOException{
		boolean result = false;
		boolean pingresultA = pingIPAddress("8.8.8.8", 53, 100); //google-public-dns-a.google.com.
		System.out.println("8.8.8.8:\t\t" + pingresultA);

		boolean pingresultB = pingIPAddress("8.8.4.4", 53, 100); //google-public-dns-b.google.com.
		System.out.println("8.8.4.4:\t\t" + pingresultB);
		
		boolean pingresultC = pingServer("www.bbc.co.uk", 80, 100); 
		System.out.println("bbc.co.uk:\t\t" + pingresultC);
		
		boolean pingresultD = pingServer("www.cnn.com", 80, 100); 
		System.out.println("cnn.com:\t\t" + pingresultD);
		
		boolean pingresultE = pingServer("www.stuttgarter-zeitung.de", 80, 100); 
		System.out.println("Stuttgarter Zeitung:\t" + pingresultE);

		if (pingresultA||pingresultB||pingresultC||pingresultD||pingresultE)
			result = true;
		System.out.println("CONNECTIVITY:\t\t" + result);
		return result;
	}

}
