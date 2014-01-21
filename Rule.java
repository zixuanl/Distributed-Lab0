package lab0;

public class Rule {
	private String action;
	private String src;
	private String dest;
	private String kind;
	private Integer seqNum;
	
	public void setRule() {
		action = null;
		src = null;
		dest = null;
		kind = null;
		seqNum = null;
	}
	
	public void setRule(Rule r) {
		action = r.action;
		src = r.src;
		dest = r.dest;
		kind = r.kind;
		seqNum = r.seqNum;
	}
	
	public void setRule(String action, String src, String dest, String kind, Integer seqNum) {
		this.action = action;
		this.dest = dest;
		this.src = src;
		this.kind = kind;
		this.seqNum = seqNum;
	}
	
	public boolean IsMatch() {
		
		return true;
	}
	
	

}
