package securities.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:autoload.xml"})
public class BootApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApp.class, args);
	}
}
