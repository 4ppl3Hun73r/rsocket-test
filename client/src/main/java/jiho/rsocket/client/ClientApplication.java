package jiho.rsocket.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;

@SpringBootApplication
public class ClientApplication {

	@Bean
	public RSocketRequester rSocketRequester(RSocketRequester.Builder builder) {
		return builder
				.connectTcp("localhost", 7000)
				.block();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
