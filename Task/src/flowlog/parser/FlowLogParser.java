package flowlog.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import flowlog.model.FlowLogV7;


public class FlowLogParser {
	private List<FlowLogV7> flowlogs;
	
	public FlowLogParser(String path) {
		this.flowlogs = new ArrayList<>();
		parseFlowLogs(path);
	}
	
	// Unparameterized constructor used mainly for Testing
	public FlowLogParser() {
		this.flowlogs = new ArrayList<>();
	}
	
	public List<FlowLogV7> getFlowlogs() {
		return flowlogs;
	}

	public void setFlowlogs(List<FlowLogV7> flowlogs) {
		this.flowlogs = flowlogs;
	}
	
	// Function to parse each Flow Log Entry to an object 
	public void parseFlowLogs(String path) {
		
		try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String fieldLine = reader.readLine();
			String[] fields = fieldLine.split(" ");
			this.flowlogs =  Files.lines(Paths.get(new URI("file://" + path.replace("\\", "/"))))
					   .skip(1)    //Skip Line 1 which has headings
					   .map(line -> line.split(" "))
					   .filter(parts -> parts.length == fields.length)  // Checking validity of the flow log record
					   .map(parts -> createObject(fields, parts))
					   .filter(Objects::nonNull)
					   .collect(Collectors.toList());
		} catch(IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// Function to create an object by instantiating only the fields that are present in the user defined logs using Builder Design Pattern
	// Creating an object of FlowLogV7 Class since it can contain any of the available fields
	public FlowLogV7 createObject(String[] fields, String[] parts) {
		try {			
			FlowLogV7.Builder<?> builder = new FlowLogV7.Builder<>();
			int index = 0;
			for(String field: fields) {
				Method method = builder.getClass().getMethod(field, String.class);
				method.invoke(builder, parts[index]);
				index += 1;
			}
			FlowLogV7 object = builder.build();
			return object;
		} catch(Exception e) {
			System.err.println("Error setting field " + e.getMessage());
		}
		return null;
	}

}
