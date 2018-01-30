package securities.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import securities.model.Instrument;
import securities.services.InstrumentService;

@RestController
public class InstrumentController {

	@Autowired
	private InstrumentService instrumentService;
	
	@RequestMapping("/instruments")
    public List<Instrument> greeting() {
		return instrumentService.findInstruments();
	}
}