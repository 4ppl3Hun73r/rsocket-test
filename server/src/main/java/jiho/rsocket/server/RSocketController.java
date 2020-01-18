package jiho.rsocket.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Controller
public class RSocketController {


    @MessageMapping("hello")
    public Mono<String> helloRSocket(String name) {
        return Mono.just("Hello " + name + ", time : " + Instant.now());
    }

    @MessageMapping("infinity/hello")
    public Flux<String> infinityHello() {
        return Flux
                .interval(Duration.ofSeconds(1))
                .map(t -> "Hello @" + Instant.now());
    }
}
