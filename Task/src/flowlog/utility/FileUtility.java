package flowlog.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileUtility {
	
	// Utility to write result data to files
	public static void writeOutput(Map<String, Long> counter, String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
        	writer.write("Port/Protocol\tCount\n");
        	for (Map.Entry<String, Long> entry : counter.entrySet()) {
        		writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        	}
        } catch(IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
	}
}
