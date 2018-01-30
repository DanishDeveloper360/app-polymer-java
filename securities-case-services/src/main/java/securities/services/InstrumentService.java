package securities.services;

import java.util.List;

import securities.model.Instrument;

public interface InstrumentService {

	List<Instrument> findInstruments();
	void registerListener(InstrumentListener listener);
	void unregisterListener(InstrumentListener listener);
}
