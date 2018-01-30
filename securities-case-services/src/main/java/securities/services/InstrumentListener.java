package securities.services;

import securities.model.Instrument;

public interface InstrumentListener {

	void priceUpdated(Instrument instrument);
}
