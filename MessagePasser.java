package lab0;

import java.io.Serializable;

public class MessagePasser implements Serializable{
	private String configuration_filename;
	private String local_name;
	
	public MessagePasser() {
		configuration_filename = null;
		local_name = null;
		
	}
	
	public MessagePasser(String configuration_filename, String local_name) {
		this.configuration_filename = configuration_filename;
		this.local_name = local_name;
	}
	
	public void send(Message message) {
		
	}
	
	public void receive() {
		
	}
	
	public static void main(String[] args){
		System.out.println("Hello World!");
	}
	
}
