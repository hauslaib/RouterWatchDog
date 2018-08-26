/**
 * @author Kyle Hauslaib
 * @version 1.0 [26.08.2018]
 * 
 * This class forms the main executable of the RouterWatchDog
 *
 */
import java.io.IOException;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean connectivity = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerPing sp = new ServerPing();
		while (true) {
			try {
				connectivity = sp.checkConnectivity();

			} catch (IOException e) {
				// TODO Exception code to restart Pi.
			} catch (Exception u) {
				// TODO Exception code to restart Pi.
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Exception code to restart Pi.
			} catch (Exception u) {
				// TODO Exception code to restart Pi.
			}
	}

	}

}
