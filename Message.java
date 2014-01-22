package lab0;

public class Message {
	
	private String dest;
	private String kind;
	private Object data;
	private String src;
	private Integer seqNum;
	private boolean dupe;
	
	public Message(){
		dest = null;
		kind = null;
		data = null;
		src = null;
		seqNum = null;
		dupe = false;
	}
		
	public Message(String dest, String kind, Object data) {
		this.dest = dest;
		this.kind = kind;
		this.data = data;
		src = null;
		seqNum = null;
		dupe = false;
		
	}
	
	public String get_Dest() {
		return dest;
	}
	
	public String get_Kind() {
		return kind;
	}
	
	public Object get_Data() {
		return data;
	}
	
	public String get_Src() {
		return src;
	}
	
	public Integer get_SeqNum() {
		return seqNum;
	}
	
	public boolean get_Dupe() {
		return dupe;
	}
	
	public void set_Dest(String dest) {
		this.dest = dest;
	}
	
	public void set_Kind(String kind) {
		this.kind = kind;
	}
	
	public void set_Data(Object data) {
		this.data = data;
	}

	
	public void set_Src(String source) {
		src = source;
	}
	
	public void set_SeqNum(int sequeceNumber) {
		seqNum = sequeceNumber;
	}
	
	public void set_Dupe(boolean dupe) {
		this.dupe = dupe;
	}

}
