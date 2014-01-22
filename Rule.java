package lab0;

public class Rule {
	private String action;
	private String src;
	private String dest;
	private String kind;
	private Integer seqNum;
	
	public Rule() {
		action = null;
		src = null;
		dest = null;
		kind = null;
		seqNum = null;
	}
	
	public Rule(Rule r) {
		action = r.action;
		src = r.src;
		dest = r.dest;
		kind = r.kind;
		seqNum = r.seqNum;
	}
	
	public Rule(String action, String src, String dest, String kind, Integer seqNum) {
		this.action = action;
		this.dest = dest;
		this.src = src;
		this.kind = kind;
		this.seqNum = seqNum;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public boolean IsMatch(Message message) {
		
		if (message.get_Src().equals(src) || src.equals(null)) {
			if (message.get_Dest().equals(dest) || dest.equals(null)) {
				if (message.get_Kind().equals(kind) || kind.equals(null)) {
					if (message.get_SeqNum().equals(seqNum) || seqNum.equals(null)) {
						if (message.get_Dupe() == false)
							return true;
					}
				} 
			}
		}
		
		return false;
	}
	
	

}
