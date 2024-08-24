package flowlog.processor;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import flowlog.model.FlowLogV7;
import flowlog.parser.FlowLogParser;

public class PortProtocolProcessorTest {

	private FlowLogParser flowLogParser;
	private PortProtocolProcessor portProtocolProcessor;
	
	@Before
	public void setUp() {
		flowLogParser = new FlowLogParser();
		
		flowLogParser.setFlowlogs(List.of(
	    		new FlowLogV7.Builder<>()
				.version("2")
		   		.accountId("123456789012")
				.interfaceId("eni-0a1b2c3d")
				.sourceAddress("10.0.1.201")
				.destinationAddress("198.51.100.2")
				.sourcePort("443")
				.destinationPort("49153")
				.protocol("6")
				.packets("25")
				.bytes("20000")
				.start("1620140761")
				.end("1620140821")
				.action("ACCEPT")
				.logStatus("OK")
		    	.build()
		    ));
		
		portProtocolProcessor = new PortProtocolProcessor(flowLogParser);
	}
	
	@Test
	public void testComputePortProtocolsCount() {
		Map<String, Long> expectedCounter = new HashMap<>();
		expectedCounter.put("49153,tcp", 1L);
		
		assertEquals(expectedCounter, portProtocolProcessor.getPortProtocolCounter());
		
	}
}
