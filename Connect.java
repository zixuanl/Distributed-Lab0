package lab0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect {
	public Connect() {}
	
	public void SetUp() throws Exception {
		System.out.println("Local server is running.");
		
		ServerSocket listener = new ServerSocket(12344);
		while(true) {
			Socket socket = new Socket();
			socket = listener.accept();
			CreateThread(socket);
		}
	}

	private static void CreateThread(final Socket client) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                //add code here
            	
            }  
        }).start();  
    }
	
}

