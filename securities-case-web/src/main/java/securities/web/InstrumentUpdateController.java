package securities.web;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import securities.model.Instrument;
import securities.services.InstrumentListener;
import securities.services.InstrumentService;

@Controller
public class InstrumentUpdateController implements InstrumentListener {
	
	@Autowired
	private InstrumentService instrumentService; 
	
	@Autowired
    private SimpMessagingTemplate template;


	@PostConstruct
	public void register() {
		instrumentService.registerListener(this);
	}
	
	@Override
	public void priceUpdated(Instrument instrument) {
		template.convertAndSend("/topic/update", instrument);
	}
	
	@PreDestroy
	public void deregister() {
		instrumentService.unregisterListener(this);
	}
}