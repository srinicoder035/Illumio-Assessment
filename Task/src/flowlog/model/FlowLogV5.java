package flowlog.model;

public class FlowLogV5 extends FlowLogV4{
	
	protected String packetSourceAWSService;
	protected String packetDestinationAWSService;
	protected String flowDirection;
	protected String trafficPath;
	
	// Constructor to enforce the use of Builder
    protected FlowLogV5(Builder<?> builder) {
        super(builder);
        this.packetSourceAWSService = builder.packetSourceAWSService;
        this.packetDestinationAWSService = builder.packetDestinationAWSService;
        this.flowDirection = builder.flowDirection;
        this.trafficPath = builder.trafficPath;
    }
		
	// Getters and Setters
	 public String getPacketSourceAWSService() {
		return packetSourceAWSService;
	}

	public void setPacketSourceAWSService(String packetSourceAWSService) {
		this.packetSourceAWSService = packetSourceAWSService;
	}

	public String getPacketDestinationAWSService() {
		return packetDestinationAWSService;
	}

	public void setPacketDestinationAWSService(String packetDestinationAWSService) {
		this.packetDestinationAWSService = packetDestinationAWSService;
	}

	public String getFlowDirection() {
		return flowDirection;
	}

	public void setFlowDirection(String flowDirection) {
		this.flowDirection = flowDirection;
	}

	public String getTrafficPath() {
		return trafficPath;
	}

	public void setTrafficPath(String trafficPath) {
		this.trafficPath = trafficPath;
	}

    // Static Nested Builder Class 
    public static class Builder<T extends Builder<T>> extends FlowLogV4.Builder<T> {
        private String packetSourceAWSService;
        private String packetDestinationAWSService;
        private String flowDirection;
        private String trafficPath;

        public T packetSourceAWSService(String packetSourceAWSService) {
            this.packetSourceAWSService = packetSourceAWSService;
            return self();
        }

        public T packetDestinationAWSService(String packetDestinationAWSService) {
            this.packetDestinationAWSService = packetDestinationAWSService;
            return self();
        }

        public T flowDirection(String flowDirection) {
            this.flowDirection = flowDirection;
            return self();
        }

        public T trafficPath(String trafficPath) {
            this.trafficPath = trafficPath;
            return self();
        }

        @SuppressWarnings("unchecked")
		@Override
        protected T self() {
            return (T) this;
        }

        @Override
        public FlowLogV5 build() {
            return new FlowLogV5(this);
        }
    }
    
}
