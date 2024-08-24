package flowlog.model;

public class FlowLogV3 extends FlowLogV2{
	protected String vpcId;
	protected String subnetId;
	protected String instanceId;
	protected String tcpFlags;
	protected String type;
	protected String packetSourceaddr;
	protected String packetDestinationaddr;
	
	// Constructor to enforce the use of Builder
	protected FlowLogV3(Builder<?> builder) {
        super(builder);
        this.vpcId = builder.vpcId;
        this.subnetId = builder.subnetId;
        this.instanceId = builder.instanceId;
        this.tcpFlags = builder.tcpFlags;
        this.type = builder.type;
        this.packetSourceaddr = builder.packetSourceaddr;
        this.packetDestinationaddr = builder.packetDestinationaddr;
    }

	// Getters and Setters
    public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getTcpFlags() {
		return tcpFlags;
	}

	public void setTcpFlags(String tcpFlags) {
		this.tcpFlags = tcpFlags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPacketSourceaddr() {
		return packetSourceaddr;
	}

	public void setPacketSourceaddr(String packetSourceaddr) {
		this.packetSourceaddr = packetSourceaddr;
	}

	public String getPacketDestinationaddr() {
		return packetDestinationaddr;
	}

	public void setPacketDestinationaddr(String packetDestinationaddr) {
		this.packetDestinationaddr = packetDestinationaddr;
	}
	
	// Static Nested Builder Class 
	public static class Builder<T extends Builder<T>> extends FlowLogV2.Builder<T> {
        private String vpcId;
        private String subnetId;
        private String instanceId;
        private String tcpFlags;
        private String type;
        private String packetSourceaddr;
        private String packetDestinationaddr;

        public T vpcId(String vpcId) {
            this.vpcId = vpcId;
            return self();
        }

        public T subnetId(String subnetId) {
            this.subnetId = subnetId;
            return self();
        }

        public T instanceId(String instanceId) {
            this.instanceId = instanceId;
            return self();
        }

        public T tcpFlags(String tcpFlags) {
            this.tcpFlags = tcpFlags;
            return self();
        }

        public T type(String type) {
            this.type = type;
            return self();
        }

        public T packetSourceaddr(String packetSourceaddr) {
            this.packetSourceaddr = packetSourceaddr;
            return self();
        }

        public T packetDestinationaddr(String packetDestinationaddr) {
            this.packetDestinationaddr = packetDestinationaddr;
            return self();
        }

        @SuppressWarnings("unchecked")
		@Override
        protected T self() {
            return (T) this;
        }

        @Override
        public FlowLogV3 build() {
            return new FlowLogV3(this);
        }
    }
	
}
