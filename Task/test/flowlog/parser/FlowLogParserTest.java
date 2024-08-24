package flowlog.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import flowlog.model.FlowLogV7;

public class FlowLogParserTest {

	private Path filePath;
	
	@Before
	public void setUp() throws Exception{
		filePath = Files.createTempFile("FlowlogTest", ".txt");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
			writer.write("version accountId interfaceId sourceAddress destinationAddress sourcePort destinationPort protocol packets bytes start end action logStatus\n");
            writer.write("2 123456789012 eni-0a1b2c3d 10.0.1.201 198.51.100.2 443 49153 6 25 20000 1620140761 1620140821 ACCEPT OK\n");
		}
	}
	
	@Test
    public void testCreateObject() {
        FlowLogParser parser = new FlowLogParser();
        String[] fields = {"version", "accountId", "interfaceId", "sourceAddress", "destinationAddress",
                "sourcePort", "destinationPort", "protocol", "packets", "bytes", "start", "end", "action", "logStatus"};
        String[] parts = {"2", "123456789012", "eni-0a1b2c3d", "10.0.1.201", "198.51.100.2", "443", "49153", "6", "25", "20000", "1620140761", "1620140821", "ACCEPT", "OK"};

        FlowLogV7 flowLog = parser.createObject(fields, parts);

        assertNotNull(flowLog);
        assertEquals("2", flowLog.getVersion());
        assertEquals("123456789012", flowLog.getAccountId());
        assertEquals("eni-0a1b2c3d", flowLog.getInterfaceId());
        assertEquals("10.0.1.201", flowLog.getSourceAddress());
        assertEquals("198.51.100.2", flowLog.getDestinationAddress());
        assertEquals("443", flowLog.getSourcePort());
        assertEquals("49153", flowLog.getDestinationPort());
        assertEquals("6", flowLog.getProtocol());
        assertEquals("25", flowLog.getPackets());
        assertEquals("20000", flowLog.getBytes());
        assertEquals("1620140761", flowLog.getStart());
        assertEquals("1620140821", flowLog.getEnd());
        assertEquals("ACCEPT", flowLog.getAction());
        assertEquals("OK", flowLog.getLogStatus());
	}
	
	@Test
    public void testParseFlowLogs() {
        FlowLogParser parser = new FlowLogParser(filePath.toString());
        List<FlowLogV7> flowLogs = parser.getFlowlogs();

        assertNotNull(flowLogs);
        assertEquals(1, flowLogs.size());
        
        FlowLogV7 flowLog = flowLogs.get(0);
        assertEquals("2", flowLog.getVersion());
        assertEquals("123456789012", flowLog.getAccountId());
        assertEquals("eni-0a1b2c3d", flowLog.getInterfaceId());
        assertEquals("10.0.1.201", flowLog.getSourceAddress());
        assertEquals("198.51.100.2", flowLog.getDestinationAddress());
        assertEquals("443", flowLog.getSourcePort());
        assertEquals("49153", flowLog.getDestinationPort());
        assertEquals("6", flowLog.getProtocol());
        assertEquals("25", flowLog.getPackets());
        assertEquals("20000", flowLog.getBytes());
        assertEquals("1620140761", flowLog.getStart());
        assertEquals("1620140821", flowLog.getEnd());
        assertEquals("ACCEPT", flowLog.getAction());
        assertEquals("OK", flowLog.getLogStatus());
    }
	
}
