package flowlog;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProtocolUtility {

	private static Map<Integer, String> protocolMap;
	private static final String PROTOCOL_MAP_FILE = "protocolNumberMapping.csv";
	
	static {
		loadProtocolMap();
	}
	
	public static void loadProtocolMap() {
		try {
			
			protocolMap = Files.lines(Paths.get(ProtocolUtility.class.getResource(PROTOCOL_MAP_FILE).toURI()))
	                .skip(1)
					.map(line -> line.split(","))
	                .filter(parts -> parts.length == 2)
	                .collect(Collectors.toMap(
	                    parts -> Integer.parseInt(parts[0]),
	                    parts -> parts[1].toLowerCase(),
	                    (v1, v2) -> v1,
	                    HashMap::new
	                ));
		} catch(Exception e) {
			throw new RuntimeException("Failed to load Protocol Utility");
		}
	}
	
	
	
	public static String getProtocolString(int protocol) {
		return protocolMap.getOrDefault(protocol, String.valueOf(protocol));
	}
}
