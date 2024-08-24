package flowlog.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileUtilityTest {

	private static final String path = Paths.get("").toAbsolutePath().toString() + "/test/flowlog/utility/TestFileUtility.txt";
	
	@Before
	public void setUp() {
		File file = new File(path);
		if(file.exists()) {
			file.delete();
		}
	}
	
	@Test
	public void testWriteOutput() throws IOException{
		Map<String, Long> sampleCounter = new HashMap<>();
		sampleCounter.put("80,tcp",10L);
		sampleCounter.put("3000,tcp", 20L);
		
		FileUtility.writeOutput(sampleCounter, path);
		
		File file = new File(path);
		assertTrue(file.exists());
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			assertEquals("Port/Protocol\tCount", reader.readLine());
			assertEquals("80,tcp\t10", reader.readLine());
			assertEquals("3000,tcp\t20", reader.readLine());
		}
	}
	
	@After
	public void tearDown() {
		File file = new File(path);
		if(file.exists()) {
			file.delete();
		}
	}
	
}