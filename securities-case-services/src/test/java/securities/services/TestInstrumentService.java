package securities.services;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import securities.model.Instrument;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/autoload.xml"})
public class TestInstrumentService {

	private static final Logger logger = Logger.getLogger(TestInstrumentService.class);
	@Autowired
	private InstrumentService instrumentService;
	
	@Test
	public void testInstrumentService() {
		InstrumentListener listener = new InstrumentListener() {
			@Override
			public void priceUpdated(Instrument instrument) {
				logger.info("Price update: "+instrument.getCode()+" -> " + instrument.getPrice().getAmount());
			}
		};
		
		instrumentService.registerListener(listener);
		try {Thread.sleep(10000);} catch (InterruptedException e) {}
		instrumentService.unregisterListener(listener);
	}
}