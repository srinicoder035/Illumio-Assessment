package flowlog.model;

public class LookupEntry {

	private int destinationPort;
	private String protocol;
	private String tag;
	
	public LookupEntry() {
		super();
	}
	
	// Constructor
	public LookupEntry(int destinationPort, String protocol, String tag) {
		super();
		this.destinationPort = destinationPort;
		this.protocol = protocol;
		this.tag = tag;
	}

	// Getters and Setters
	public int getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "LookupEntry [destinationPort=" + destinationPort + ", protocol=" + protocol + ", tag=" + tag + "]";
	}
	
}
