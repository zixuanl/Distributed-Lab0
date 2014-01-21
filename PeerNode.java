package lab0;

public class PeerNode {
	private String name;
	private String ip;
	private Long port;
	
	public PeerNode() {
		name = null;
		ip = null;
		port = null;
	}

	public PeerNode(String name, String ip, Long port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	
	
	
}
