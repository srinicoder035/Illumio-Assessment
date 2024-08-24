package flowlog.processor;

import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import flowlog.model.FlowLogV7;
import flowlog.parser.FlowLogParser;
import flowlog.utility.FileUtility;

public class PortProtocolProcessor {
	
	// Hashmap to store the result in the form of key(port, protocol), value (count) pairs.
	private Map<String, Long> portProtocolCounter;
	private String RESULT_FILE;
	
	
	public PortProtocolProcessor(FlowLogParser flowlogParser) {
		this.RESULT_FILE = Paths.get("").toAbsolutePath().toString() + "/src/flowlog/resource/PortProtocolCount.txt";
		// Calling computePortProtocolsCount to compute the port protocol counter
		this.portProtocolCounter = computePortProtocolsCount(flowlogParser);
		// Writing the output result to a file
		FileUtility.writeOutput(this.portProtocolCounter, this.RESULT_FILE);		
	}
	
	public Map<String, Long> getPortProtocolCounter() {
		return portProtocolCounter;
	}

	public void setPortProtocolCounter(Map<String, Long> portProtocolCounter) {
		this.portProtocolCounter = portProtocolCounter;
	}
		
	// Map Reduce Function to count the port protocol combinations
	public Map<String, Long> computePortProtocolsCount(FlowLogParser flowlogParser) {
		return flowlogParser.getFlowlogs().stream()
				.map(FlowLogV7::getPortProtocolKey)
	            .collect(Collectors.groupingBy(
	                key -> key,
	                Collectors.counting()
	            ));
	}
	
}
