package flowlog.parser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import flowlog.model.LookupEntry;

public class LookupParser {
	
	// LookupTable contains the list of entries in the lookup table
	private List<LookupEntry> lookupTable;
	// LookupMapper is used to store key (destination port, protocol) and value (tag) pairs for faster access
	private Map<String, String> lookupMapper;
	
	public LookupParser(String path) {
		this.lookupTable = new ArrayList<>();
		this.lookupMapper = new HashMap<>();
		parseLookupTable(path);
	}
	
	//Unparameterized constructor used mainly for Testing 
	public LookupParser() {
		this.lookupTable = new ArrayList<>();
		this.lookupMapper = new HashMap<>();
	}
	
	public Map<String, String> getLookupMapper() {
		return lookupMapper;
	}

	public void setLookupMapper(Map<String, String> lookupMapper) {
		this.lookupMapper = lookupMapper;
	}

	public List<LookupEntry> getLookupTable() {
		return lookupTable;
	}

	public void setLookupTable(List<LookupEntry> lookupTable) {
		this.lookupTable = lookupTable;
	}

	// Function to parse each Lookup Entry into an object
	public void parseLookupTable(String path) {
	    try {
	    	this.lookupTable =  Files.lines(Paths.get(new URI("file://" + path.replace("\\", "/"))))
	            .skip(1)    // Skip line 1 which contains heading
	            .map(line -> line.split(",")) // Separator used is a comma since it is a CSV file
	            .filter(parts -> parts.length == 3) // Check for valid entries in the Lookup Table
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
	        //Each object is loaded into the Hashmap for quick access
	    	this.lookupTable.forEach(entry -> {
	        	String key = Integer.toString(entry.getDestinationPort()) + "," + entry.getProtocol();
	        	this.lookupMapper.put(key, entry.getTag());
	        });
	    } catch (IOException | URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
}
