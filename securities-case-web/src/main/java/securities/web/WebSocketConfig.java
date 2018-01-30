package securities.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// the endpoint for websocket connections
		registry.addEndpoint("/stomp").withSockJS();

		// Allow requests from localhost:8081 server
		// registry.addEndpoint("/stomp").setAllowedOrigins("http://localhost:8081").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// use the /topic prefix for outgoing WebSocket communication
		config.enableSimpleBroker("/topic");

		// use the /app prefix for others
		config.setApplicationDestinationPrefixes("/app");
	}
}