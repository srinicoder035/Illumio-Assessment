package flowlog.utility;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProtocolUtilityTest {
	
	private static final String TEST_CSV_PATH = Paths.get("").toAbsolutePath().toString() + "/test/flowlog/utility/TestProtocolMapping.csv";
	
	@Before
	public void setUp() throws IOException {
		String content = "ProtocolNumber,Name\n"
				        + "6,tcp\n"
				        + "17,udp\n"
				        + "41,ipv6\n";
		Files.write(Paths.get(TEST_CSV_PATH), content.getBytes());
		ProtocolUtility.loadProtocolMap(TEST_CSV_PATH);
	}
	
	@Test
	public void testLoadProtocolMap() {
		Map<Integer, String> protocolMap = ProtocolUtility.getProtocolMap();
		
		assertEquals("tcp", protocolMap.getOrDefault(6,"Not Found"));
		assertEquals("udp", protocolMap.getOrDefault(17, "Not Found"));
		assertEquals("ipv6", protocolMap.getOrDefault(41, "Not Found"));
		assertEquals("Not Found", protocolMap.getOrDefault(0, "Not Found"));
		
	}
	
	@Test
	public void testGetProtocolString() {
		assertEquals("tcp", ProtocolUtility.getProtocolString(6));
		assertEquals("udp", ProtocolUtility.getProtocolString(17));
		assertEquals("ipv6", ProtocolUtility.getProtocolString(41));
		assertEquals("0", ProtocolUtility.getProtocolString(0));
	}
	
	@After
	public void tearDown() throws IOException {
		Path path = Paths.get(TEST_CSV_PATH);
		Files.delete(path);
	}
}
