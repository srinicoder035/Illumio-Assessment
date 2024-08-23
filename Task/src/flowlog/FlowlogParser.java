package flowlog;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;


public class FlowlogParser {

//	private static final String FLOW_LOG_FILE = "FlowLogs.txt";
//	private static final String LOOKUP_TABLE_FILE = "LookupTable.csv";
	private static final String LOOKUP_TABLE_FILE = "stressTestLookup.csv";
	private static final String FLOW_LOG_FILE = "stressTestFlowLog.txt";
	private List<LookupEntry> lookupTable = new ArrayList<>();
	private List<FlowLogEntry> flowlogs = new ArrayList<>();
	private Map<String, Long> tagCounter = new HashMap<>();
	private Map<String, Long> portProtocolCounter = new HashMap<>();
	private Map<String, String> lookupMapper = new HashMap<>();
	
	
	public void loadLookupTable() {
	    try {
	    	URI uri = getClass().getResource(LOOKUP_TABLE_FILE).toURI();
            lookupTable = Files.lines(Paths.get(uri))
	            .skip(1) 
	            .map(line -> line.split(","))
	            .filter(parts -> parts.length == 3) 
	            .map(parts -> {
	                try {
	                    return new LookupEntry(
	                        Integer.parseInt(parts[0]),
	                        parts[1].toLowerCase(),
	                        parts[2]);
	                } catch (NumberFormatException e) {
	                    System.err.println("Invalid port number in line: " + String.join(",", parts));
	                    return null;
	                }
	            })
	            .filter(Objects::nonNull)
	            .collect(Collectors.toList());
	        lookupTable.forEach(entry -> {
	        	String key = Integer.toString(entry.getDestinationPort()) + "," + entry.getProtocol();
	        	lookupMapper.put(key, entry.getTag());
	        });
	    } catch (IOException | URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadFlowLogs() {
		try {
			URI uri = getClass().getResource(FLOW_LOG_FILE).toURI();
			flowlogs = Files.lines(Paths.get(uri))
					   .map(line -> line.split(" "))
					   .filter(parts -> parts.length == 14)
					   .map(parts -> {
						   try {
							   return new FlowLogEntry(
									Integer.parseInt(parts[0]),
									parts[1],
									parts[2],
									parts[3],
									parts[4],
									Integer.parseInt(parts[5]),
									Integer.parseInt(parts[6]),
									Integer.parseInt(parts[7]),
									Integer.parseInt(parts[8]),
									Integer.parseInt(parts[9]),
									Integer.parseInt(parts[10]),
									Integer.parseInt(parts[11]),
									parts[12],
									parts[13]);
						   } catch(NumberFormatException e) {
							   e.printStackTrace();
							   return null;
						   }
					   })
					   .filter(Objects::nonNull)
					   .collect(Collectors.toList());
		} catch(IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void parseFlowLogs() {
		portProtocolCounter = getPortProtocolsCount();
		tagCounter = getTagsCount();
	}
	
	
	public Map<String, Long> getPortProtocolsCount() {
		return flowlogs.stream()
				.map(FlowLogEntry::getPortProtocolKey)
	            .collect(Collectors.groupingBy(
	                key -> key,
	                Collectors.counting()
	            ));
	}
	
	public Map<String, Long> getTagsCount() {
		return flowlogs.stream()
				.map(flowLog -> lookupMapper.getOrDefault(flowLog.getPortProtocolKey(), "Untagged"))
				.collect(Collectors.groupingBy(
					key -> key,
					Collectors.counting()
				));
	}
	
	
	public static void main(String[] args) {
		FlowlogParser parser = new FlowlogParser();
		long time1 = System.nanoTime();
		parser.loadLookupTable();
		parser.loadFlowLogs();
		parser.parseFlowLogs();
		long time2 = System.nanoTime();
		long diff = time2 - time1;
		System.out.printf("Total Execution Time is %f seconds\n",(double)diff / 1000000000);
		System.out.println(parser.portProtocolCounter);
		System.out.println(parser.tagCounter);
		System.out.println(parser.flowlogs.size());
	}
}
