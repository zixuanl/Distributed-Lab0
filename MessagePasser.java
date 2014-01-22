package lab0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MessagePasser implements Serializable{
	private String configuration_filename;
	private String local_name;
	private AtomicInteger seqNum = new AtomicInteger(-1);
	private ConcurrentLinkedQueue<Message> ReciverBuffer = new ConcurrentLinkedQueue<Message>();
	private ConcurrentLinkedQueue<Message> SenderBuffer = new ConcurrentLinkedQueue<Message>();
	private ConcurrentLinkedQueue<Message> DelayBuffer = new ConcurrentLinkedQueue<Message>();
	private ArrayList<Rule> RuleSet = new ArrayList<Rule>();
	private ArrayList<PeerNode> NodeSet = new ArrayList<PeerNode>();
	private static ServerSocket listener;
	
	public MessagePasser() {
		configuration_filename = null;
		local_name = null;
		
	}
	
	public MessagePasser(String configuration_filename, String local_name) {
		this.configuration_filename = configuration_filename;
		this.local_name = local_name;
	}
	
	public void send(Message message) {
		Rule r = check_rule(message);
		if (r != null) {
			r.getAction();
			//add code here
		} 
		
		System.out.println("Send message from SenderBuffer");
	}
	
	public void receive() {
		System.out.println("Read message from ReceiverBuffer");
	}
	
	public static void SetUp() throws Exception {
		System.out.println("Local server is running.");
		
		try {
			while(true) {
				Socket socket = new Socket();
				socket = listener.accept();
				CreateListenThread(socket);
			} 
		} 
		catch (SocketException e) {
				// TODO Auto-generated catch block
				
			}
		finally {
			listener.close();
			}
	}

	private static void CreateListenThread(final Socket socket) throws IOException {  
         new Thread(new Runnable() {  
            public void run() {  
            try {
                String readline = new String("");
            	BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	readline = is.readLine();
            	while (readline != null) {			
					System.out.println("Server is reveiving: "+ readline);
					readline = is.readLine();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            	
            }  
        }).start(); 
    }
	
	
	private void CreateThread() throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                try {
					SetUp();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }  
        }).start();  
    }
	
	public Rule check_rule(Message message) {
		for (int i = 0; i < RuleSet.size(); i++) {
			if (RuleSet.get(i).IsMatch(message))
				return RuleSet.get(i);
		}
		return null;
	}
	
	
	public static void main(String[] args) throws Exception{
		String configuration_filename = new String("");
		String local_name = new String("");
		String send_info = new String("");
		listener = new ServerSocket(12344);
		Message message = new Message();
		//Scanner in =new Scanner(System.in);
		//configuration_filename = in.next();
		//local_name = in.next();
		MessagePasser MP = new MessagePasser(configuration_filename, local_name);

		
		
		MP.CreateThread();
		
		Socket socket = new Socket("128.237.174.156",12344);
		PrintWriter ot = new PrintWriter(socket.getOutputStream());
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		send_info = input.readLine();
		
		
		
		while (!send_info.equals("exit")) {
			String[] command = send_info.split(" ");
			if (command.length != 2 || !(command[0].equals("send") || command[0].equals("read"))) {
				System.out.println("Enter the right command!");
				send_info = input.readLine();
				continue;
				}
			if (command[0].equals("read")) {
				MP.receive();
				send_info = input.readLine();
				continue;
			}
			if (command[0].equals("send")) {
				ot.println(send_info);
				ot.flush();
				send_info = input.readLine();
				continue;
			}
		}
		
		//System.out.println(configuration_filename);
		//System.out.println(local_name);
		socket.close();
		listener.close();
		System.out.println("Program exit normally");

		
		
	}
	
}
