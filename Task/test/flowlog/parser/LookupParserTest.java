package flowlog.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import flowlog.model.LookupEntry;

public class LookupParserTest {
	private Path filePath;
	
	@Before
	public void setUp() throws Exception{
		filePath = Files.createTempFile("LookupTest", ".csv");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
			writer.write("dstprotocol,protocol,tag\n");
			writer.write("25,tcp,sv_P1\n");
            writer.write("68,udp,sv_P2\n");
            writer.write("23,tcp,sv_P1\n");
            writer.write("31,udp,SV_P3\n");
		}
	}
	
	@Test
	public void testParseLookupTable() {
        LookupParser parser = new LookupParser(filePath.toString());

        List<LookupEntry> lookupTable = parser.getLookupTable();
        assertNotNull(lookupTable);
        assertEquals(4, lookupTable.size());

        Map<String, String> lookupMapper = parser.getLookupMapper();
        assertNotNull(lookupMapper);
        assertEquals(4, lookupMapper.size());

        // Verify specific entries
        assertEquals("sv_P1", lookupMapper.getOrDefault("25,tcp","Untagged"));
        assertEquals("sv_P2", lookupMapper.getOrDefault("68,udp","Untagged"));
        assertEquals("SV_P3", lookupMapper.getOrDefault("31,udp","Untagged"));
        assertEquals("Untagged", lookupMapper.getOrDefault("99,udp","Untagged"));
    }
}
