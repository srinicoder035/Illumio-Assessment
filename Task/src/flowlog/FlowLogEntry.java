package flowlog;

public class FlowLogEntry {
	
	private int version;
	private String accountId;
	private String interfaceId;
	private String sourceAddress;
	private String destinationAddress;
	private int sourcePort;
	private int destionationPort;
	private int protocol;
	private int packets;
	private int bytes;
	private int start;
	private int end;
	private String action;
	private String logStatus;
	
	public FlowLogEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlowLogEntry(int version, String accountId, String interfaceId, String sourceAddress,
			String destinationAddress, int sourcePort, int destionationPort, int protocol, int packets, int bytes,
			int start, int end, String action, String logStatus) {
		super();
		this.version = version;
		this.accountId = accountId;
		this.interfaceId = interfaceId;
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.sourcePort = sourcePort;
		this.destionationPort = destionationPort;
		this.protocol = protocol;
		this.packets = packets;
		this.bytes = bytes;
		this.start = start;
		this.end = end;
		this.action = action;
		this.logStatus = logStatus;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}

	public int getDestionationPort() {
		return destionationPort;
	}

	public void setDestionationPort(int destionationPort) {
		this.destionationPort = destionationPort;
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getPackets() {
		return packets;
	}

	public void setPackets(int packets) {
		this.packets = packets;
	}

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}

	@Override
	public String toString() {
		return "FlowLogEntry [version=" + version + ", accountId=" + accountId + ", interfaceId=" + interfaceId
				+ ", sourceAddress=" + sourceAddress + ", destinationAddress=" + destinationAddress + ", sourcePort="
				+ sourcePort + ", destionationPort=" + destionationPort + ", protocol=" + protocol + ", packets="
				+ packets + ", bytes=" + bytes + ", start=" + start + ", end=" + end + ", action=" + action
				+ ", logStatus=" + logStatus + "]";
	}
	
	public String getPortProtocolKey() {
		return Integer.toString(this.getDestionationPort()) + "," + ProtocolUtility.getProtocolString(this.protocol);
	}
	
	
}