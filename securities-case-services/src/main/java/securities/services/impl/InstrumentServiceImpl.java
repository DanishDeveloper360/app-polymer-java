package securities.services.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import securities.model.Instrument;
import securities.model.Price;
import securities.services.InstrumentListener;
import securities.services.InstrumentService;

@Service
public class InstrumentServiceImpl implements InstrumentService {
	
	private Set<InstrumentListener> listeners = new HashSet<>();
	private Random random = new Random();
	private static final int UPDATE_COUNT = 5;
	
	@Override
	public List<Instrument> findInstruments() {
		return TEST_INSTRUMENTS;
	}

	@Override
	public void registerListener(InstrumentListener listener) {
		listeners.add(listener);

	}

	@Override
	public void unregisterListener(InstrumentListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * Update the instrument prices by
	 * 1. Pick 5 random instruments
	 * 2. Update the price of this instrument
	 * 3. Inform the listeners
	 */
	@Scheduled(fixedRate=1000)
	public void run() {
		List<Instrument> instruments = findInstruments();
		for (int i=0; i<UPDATE_COUNT;i++) {
			Instrument instrument = instruments.get(random.nextInt(instruments.size()));
			Price updatedPrice;
			if (instrument.hasPrice()) {
				updatedPrice = instrument.getPrice();
				updatedPrice.setAmount(Math.max(0.2, updatedPrice.getAmount() + (random.nextDouble()-0.5)));
			} else {
				updatedPrice = new Price();
				instrument.setPrice(updatedPrice);
				updatedPrice.setAmount(random.nextDouble() * 10); //Gives a random price [0,10)
			}
			updatedPrice.setWhen(System.currentTimeMillis());
			
			for (InstrumentListener listener : listeners) {
				listener.priceUpdated(instrument);
			}
		}
		
	}
	
	private static List<Instrument> TEST_INSTRUMENTS = Arrays.asList(
			new Instrument[] {
				new Instrument("Aegon"), 
				new Instrument("Ahold"), 
				new Instrument("Akzo Nobel"), 
				new Instrument("Altice -A-"), 
				new Instrument("ArcelorMittal"), 
				new Instrument("ASML Holding"), 
				new Instrument("Boskalis Westminster"), 
				new Instrument("Delta Lloyd"), 
				new Instrument("DSM"), 
				new Instrument("Gemalto"), 
				new Instrument("Heineken"), 
				new Instrument("ING Groep"),
				new Instrument("KPN"), 
				new Instrument("NN Group"), 
				new Instrument("OCI"), 
				new Instrument("Philips"), 
				new Instrument("Randstad Holding"), 
				new Instrument("RELX"), 
				new Instrument("Royal Dutch Shell -A-"), 
				new Instrument("TNT Express"), 
				new Instrument("Unibail-Rodamco"), 
				new Instrument("Unilever"), 
				new Instrument("Vopak"), 
				new Instrument("Wolters Kluwer")
			});
}
