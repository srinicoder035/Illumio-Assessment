package flowlog.model;

public abstract class BaseFlowLogEntry {

	protected String version;
	protected String accountId;
	protected String interfaceId;
	protected String sourceAddress;
	protected String destinationAddress;
	protected String sourcePort;
	protected String destinationPort;
	protected String protocol;
	
	// Constructor to enforce the use of Builder
	protected BaseFlowLogEntry(Builder<?> builder) {
        this.version = builder.version;
        this.accountId = builder.accountId;
        this.interfaceId = builder.interfaceId;
        this.sourceAddress = builder.sourceAddress;
        this.destinationAddress = builder.destinationAddress;
        this.sourcePort = builder.sourcePort;
        this.destinationPort = builder.destinationPort;
        this.protocol = builder.protocol;
    }

	// Getters and Setters
    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
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

	public String getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	// Static Nested Builder class 
	public static abstract class Builder<T extends Builder<T>> {
        private String version;
        private String accountId;
        private String interfaceId;
        private String sourceAddress;
        private String destinationAddress;
        private String sourcePort;
        private String destinationPort;
        private String protocol;

        public T version(String version) {
            this.version = version;
            return self();
        }

        public T accountId(String accountId) {
            this.accountId = accountId;
            return self();
        }

        public T interfaceId(String interfaceId) {
            this.interfaceId = interfaceId;
            return self();
        }

        public T sourceAddress(String sourceAddress) {
            this.sourceAddress = sourceAddress;
            return self();
        }

        public T destinationAddress(String destinationAddress) {
            this.destinationAddress = destinationAddress;
            return self();
        }

        public T sourcePort(String sourcePort) {
            this.sourcePort = sourcePort;
            return self();
        }

        public T destinationPort(String destinationPort) {
            this.destinationPort = destinationPort;
            return self();
        }

        public T protocol(String protocol) {
            this.protocol = protocol;
            return self();
        }

        protected abstract T self();

        public abstract BaseFlowLogEntry build();
    }

}