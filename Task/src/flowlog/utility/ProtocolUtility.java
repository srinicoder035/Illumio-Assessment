package flowlog.utility;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Utility class to access Protocol number and names for easy access in the codebase
public class ProtocolUtility {

	// Hashmap to store the Protocol number and Names respectively
	private static Map<Integer, String> protocolMap;
	private static final String PROTOCOL_MAP_FILE = Paths.get("").toAbsolutePath().toString() + "/src/flowlog/resource/ProtocolNumberMapping.csv";
	
	static {
		loadProtocolMap(PROTOCOL_MAP_FILE);
	}
	
	public static Map<Integer, String> getProtocolMap() {
		return protocolMap;
	}

	public static void setProtocolMap(Map<Integer, String> protocolMap) {
		ProtocolUtility.protocolMap = protocolMap;
	}
	
	// Function to initialize Hashmap from contents of the file
	public static void loadProtocolMap(String path) {
		try {
			protocolMap = Files.lines(Paths.get(new URI("file://" + path.replace("\\", "/"))))
					.skip(1)          // Skip line 1 since it contains heading names
					.map(line -> line.split(","))
	                .filter(parts -> parts.length == 2)      // Checking for valid data
	                .collect(Collectors.toMap(
	                    parts -> Integer.parseInt(parts[0]),
	                    parts -> parts[1].toLowerCase(),
	                    (v1, v2) -> v1,                // Incase of duplicates, retain earlier value
	                    HashMap::new
	                ));
	              
		} catch(Exception e) {
			throw new RuntimeException("Failed to load Protocol Utility " + e.getMessage());
		}
	}
	
	//Utility Function to provide protocol name for corresponding protocol number
	public static String getProtocolString(int protocol) {
		// Return Protocol Name if present else return string equivalent of the protocol number
		return protocolMap.getOrDefault(protocol, String.valueOf(protocol));
	}
	
}
