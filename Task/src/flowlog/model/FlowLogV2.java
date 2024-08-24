package flowlog.model;

public class FlowLogV2 extends BaseFlowLogEntry{
	
	protected String packets;
	protected String bytes;
	protected String start;
	protected String end;
	protected String action;
	protected String logStatus;
	
	// Constructor to enforce the use of Builder
	protected FlowLogV2(Builder<?> builder) {
        super(builder);
        this.packets = builder.packets;
        this.bytes = builder.bytes;
        this.start = builder.start;
        this.end = builder.end;
        this.action = builder.action;
        this.logStatus = builder.logStatus;
    }

	// Getters and Setters
    public String getPackets() {
		return packets;
	}

	public void setPackets(String packets) {
		this.packets = packets;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
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

	// Static Nested Builder Class 
	public static class Builder<T extends Builder<T>> extends BaseFlowLogEntry.Builder<T> {
        private String packets;
        private String bytes;
        private String start;
        private String end;
        private String action;
        private String logStatus;

        public T packets(String packets) {
            this.packets = packets;
            return self();
        }

        public T bytes(String bytes) {
            this.bytes = bytes;
            return self();
        }

        public T start(String start) {
            this.start = start;
            return self();
        }

        public T end(String end) {
            this.end = end;
            return self();
        }

        public T action(String action) {
            this.action = action;
            return self();
        }

        public T logStatus(String logStatus) {
            this.logStatus = logStatus;
            return self();
        }

        @SuppressWarnings("unchecked")
		@Override
        protected T self() {
            return (T) this;
        }

        @Override
        public FlowLogV2 build() {
            return new FlowLogV2(this);
        }
    }
}
