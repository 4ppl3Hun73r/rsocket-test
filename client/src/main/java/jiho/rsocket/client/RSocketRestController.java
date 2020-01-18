package jiho.rsocket.client;

import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RSocketRestController {

    private final RSocketRequester rSocketRequester;

    public RSocketRestController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping("hello/{name}")
    public Publisher<String> hello(@PathVariable String name) {
        return rSocketRequester
            .route("hello")
            .data(name)
            .retrieveMono(String.class);
    }

    @GetMapping("infinity/hello")
    public Publisher<String> infinityHello() {
        return rSocketRequester
                .route("infinity/hello")
                .retrieveFlux(String.class);
    }
}
