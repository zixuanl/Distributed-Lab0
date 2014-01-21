package lab0;

public class Message {
	
	private String dest;
	private String kind;
	private Object data;
	
	public Message(){
		dest = null;
		kind = null;
		data = null;
	}
		
	public Message(String dest, String kind, Object data) {
		this.dest = dest;
		this.kind = kind;
		this.data = data;
		
	}
	
	public void set_source(String source) {
		
	}
	
	public void set_seqNum(int sequeceNumber) {
		
	}
	
	public void set_duplicate(boolean dupe) {
		
		
	}

}
