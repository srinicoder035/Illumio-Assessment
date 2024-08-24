package flowlog.processor;

import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


import flowlog.parser.FlowLogParser;
import flowlog.parser.LookupParser;
import flowlog.utility.FileUtility;

public class TagCounterProcessor {

	// Hashmap to store the result in the form of key(tag), value (count) pairs.
	private Map<String, Long> tagCounter;
	private String RESULT_FILE;
	
	
	public TagCounterProcessor(FlowLogParser flowlogParser, LookupParser lookupParser) {
		this.RESULT_FILE = Paths.get("").toAbsolutePath().toString() + "/src/flowlog/resource/TagCount.txt";
		// Calling computeTagsCount to compute the tag counter
		this.tagCounter = computeTagsCount(flowlogParser, lookupParser);
		// Writing the output result to a file
		FileUtility.writeOutput(tagCounter, RESULT_FILE);
	}
	
	public Map<String, Long> getTagCounter() {
		return tagCounter;
	}

	public void setTagCounter(Map<String, Long> tagCounter) {
		this.tagCounter = tagCounter;
	}
	
	// Map Reduce Functionality to compute the number of tags
	public Map<String, Long> computeTagsCount(FlowLogParser flowlogParser, LookupParser lookupParser) {
		return flowlogParser.getFlowlogs().stream()
				.map(flowLog -> lookupParser.getLookupMapper().getOrDefault(flowLog.getPortProtocolKey(), "Untagged"))
				.collect(Collectors.groupingBy(
					key -> key,
					Collectors.counting()
				));
	}

}
