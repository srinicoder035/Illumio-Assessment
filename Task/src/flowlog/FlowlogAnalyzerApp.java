package flowlog;

import java.nio.file.Paths;

import flowlog.parser.FlowLogParser;
import flowlog.parser.LookupParser;
import flowlog.processor.PortProtocolProcessor;
import flowlog.processor.TagCounterProcessor;


public class FlowlogAnalyzerApp {

	// Instances to parse the files and store data
	private FlowLogParser flowLogParser;
	private LookupParser lookupParser;
	
	// Instances of the class to process the tag and port protocol count computation
	private TagCounterProcessor tagCounterProcessor;
	private PortProtocolProcessor portProtocolProcessor;
	
	// File containing the logs and lookup table
	private String FLOW_LOG_FILE;
	private String LOOKUP_FILE;
	
	public FlowlogAnalyzerApp() {
		this.FLOW_LOG_FILE = Paths.get("").toAbsolutePath().toString() + "/src/flowlog/resource/StressTestFlowLogCustom.txt";
		this.LOOKUP_FILE = Paths.get("").toAbsolutePath().toString() + "/src/flowlog/resource/StressTestLookupCustom.csv";
		this.lookupParser = new LookupParser(this.LOOKUP_FILE);
		this.flowLogParser = new FlowLogParser(this.FLOW_LOG_FILE);
		this.tagCounterProcessor = new TagCounterProcessor(this.flowLogParser, this.lookupParser);
		this.portProtocolProcessor = new PortProtocolProcessor(this.flowLogParser);
	}
			
	public static void main(String[] args) {
		FlowlogAnalyzerApp parser = new FlowlogAnalyzerApp();
		
		// Printing the result for both tag and port protocol counters
		System.out.println(parser.tagCounterProcessor.getTagCounter());
		System.out.println(parser.portProtocolProcessor.getPortProtocolCounter());
	}
}
