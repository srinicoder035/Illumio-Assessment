package flowlog.model;

import flowlog.utility.ProtocolUtility;

public class FlowLogV7 extends FlowLogV5{

	protected String ecsClusterArn;
	protected String ecsClusterName;
	protected String ecsContainerInstanceArn;
	protected String ecsContainerInstanceId;
	protected String ecsContainerId;
	protected String ecsSecondContainerId;
	protected String ecsServiceName;
	protected String ecsTaskDefinitionArn;
	protected String ecsTaskArn;
	protected String ecsTaskId;
	
	// Constructor to enforce the use of Builder
	protected FlowLogV7(Builder<?> builder) {
        super(builder);
        this.ecsClusterArn = builder.ecsClusterArn;
        this.ecsClusterName = builder.ecsClusterName;
        this.ecsContainerInstanceArn = builder.ecsContainerInstanceArn;
        this.ecsContainerInstanceId = builder.ecsContainerInstanceId;
        this.ecsContainerId = builder.ecsContainerId;
        this.ecsSecondContainerId = builder.ecsSecondContainerId;
        this.ecsServiceName = builder.ecsServiceName;
        this.ecsTaskDefinitionArn = builder.ecsTaskDefinitionArn;
        this.ecsTaskArn = builder.ecsTaskArn;
        this.ecsTaskId = builder.ecsTaskId;
    }

	
	// Getters and Setters
	public String getEcsClusterArn() {
		return ecsClusterArn;
	}

	public void setEcsClusterArn(String ecsClusterArn) {
		this.ecsClusterArn = ecsClusterArn;
	}

	public String getEcsClusterName() {
		return ecsClusterName;
	}

	public void setEcsClusterName(String ecsClusterName) {
		this.ecsClusterName = ecsClusterName;
	}

	public String getEcsContainerInstanceArn() {
		return ecsContainerInstanceArn;
	}

	public void setEcsContainerInstanceArn(String ecsContainerInstanceArn) {
		this.ecsContainerInstanceArn = ecsContainerInstanceArn;
	}

	public String getEcsContainerInstanceId() {
		return ecsContainerInstanceId;
	}

	public void setEcsContainerInstanceId(String ecsContainerInstanceId) {
		this.ecsContainerInstanceId = ecsContainerInstanceId;
	}

	public String getEcsContainerId() {
		return ecsContainerId;
	}

	public void setEcsContainerId(String ecsContainerId) {
		this.ecsContainerId = ecsContainerId;
	}

	public String getEcsSecondContainerId() {
		return ecsSecondContainerId;
	}

	public void setEcsSecondContainerId(String ecsSecondContainerId) {
		this.ecsSecondContainerId = ecsSecondContainerId;
	}

	public String getEcsServiceName() {
		return ecsServiceName;
	}

	public void setEcsServiceName(String ecsServiceName) {
		this.ecsServiceName = ecsServiceName;
	}

	public String getEcsTaskDefinitionArn() {
		return ecsTaskDefinitionArn;
	}

	public void setEcsTaskDefinitionArn(String ecsTaskDefinitionArn) {
		this.ecsTaskDefinitionArn = ecsTaskDefinitionArn;
	}

	public String getEcsTaskArn() {
		return ecsTaskArn;
	}

	public void setEcsTaskArn(String ecsTaskArn) {
		this.ecsTaskArn = ecsTaskArn;
	}

	public String getEcsTaskId() {
		return ecsTaskId;
	}

	public void setEcsTaskId(String ecsTaskId) {
		this.ecsTaskId = ecsTaskId;
	}
	
	// Function to get destination port and names of protocol
	public String getPortProtocolKey() {
		// Using utility to get the name of the protocol when provided with its number
		return this.getDestinationPort() + "," + ProtocolUtility.getProtocolString(Integer.parseInt(this.getProtocol()));
	}
	
	// Static Nested Builder Class 
    public static class Builder<T extends Builder<T>> extends FlowLogV5.Builder<T> {
        private String ecsClusterArn;
        private String ecsClusterName;
        private String ecsContainerInstanceArn;
        private String ecsContainerInstanceId;
        private String ecsContainerId;
        private String ecsSecondContainerId;
        private String ecsServiceName;
        private String ecsTaskDefinitionArn;
        private String ecsTaskArn;
        private String ecsTaskId;

        public T ecsClusterArn(String ecsClusterArn) {
            this.ecsClusterArn = ecsClusterArn;
            return self();
        }

        public T ecsClusterName(String ecsClusterName) {
            this.ecsClusterName = ecsClusterName;
            return self();
        }

        public T ecsContainerInstanceArn(String ecsContainerInstanceArn) {
            this.ecsContainerInstanceArn = ecsContainerInstanceArn;
            return self();
        }

        public T ecsContainerInstanceId(String ecsContainerInstanceId) {
            this.ecsContainerInstanceId = ecsContainerInstanceId;
            return self();
        }

        public T ecsContainerId(String ecsContainerId) {
            this.ecsContainerId = ecsContainerId;
            return self();
        }

        public T ecsSecondContainerId(String ecsSecondContainerId) {
            this.ecsSecondContainerId = ecsSecondContainerId;
            return self();
        }

        public T ecsServiceName(String ecsServiceName) {
            this.ecsServiceName = ecsServiceName;
            return self();
        }

        public T ecsTaskDefinitionArn(String ecsTaskDefinitionArn) {
            this.ecsTaskDefinitionArn = ecsTaskDefinitionArn;
            return self();
        }

        public T ecsTaskArn(String ecsTaskArn) {
            this.ecsTaskArn = ecsTaskArn;
            return self();
        }

        public T ecsTaskId(String ecsTaskId) {
            this.ecsTaskId = ecsTaskId;
            return self();
        }

        @SuppressWarnings("unchecked")
		@Override
        protected T self() {
            return (T) this;
        }

        @Override
        public FlowLogV7 build() {
            return new FlowLogV7(this);
        }
    }
}
