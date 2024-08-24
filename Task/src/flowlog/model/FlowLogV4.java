package flowlog.model;

public class FlowLogV4 extends FlowLogV3{
	
	protected String region;
	protected String availabilityZone;
	protected String sublocationType;
	protected String sublocationId;
	
	// Constructor to enforce the use of the builder
    protected FlowLogV4(Builder<?> builder) {
        super(builder);
        this.region = builder.region;
        this.availabilityZone = builder.availabilityZone;
        this.sublocationType = builder.sublocationType;
        this.sublocationId = builder.sublocationId;
    }

 // Getters and Setters
    public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public String getSublocationType() {
		return sublocationType;
	}

	public void setSublocationType(String sublocationType) {
		this.sublocationType = sublocationType;
	}

	public String getSublocationId() {
		return sublocationId;
	}

	public void setSublocationId(String sublocationId) {
		this.sublocationId = sublocationId;
	}

	// Static Nested Builder Class
    public static class Builder<T extends Builder<T>> extends FlowLogV3.Builder<T> {
        private String region;
        private String availabilityZone;
        private String sublocationType;
        private String sublocationId;

        public T region(String region) {
            this.region = region;
            return self();
        }

        public T availabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return self();
        }

        public T sublocationType(String sublocationType) {
            this.sublocationType = sublocationType;
            return self();
        }

        public T sublocationId(String sublocationId) {
            this.sublocationId = sublocationId;
            return self();
        }

        @SuppressWarnings("unchecked")
		@Override
        protected T self() {
            return (T) this;
        }

        @Override
        public FlowLogV4 build() {
            return new FlowLogV4(this);
        }
    }
}
