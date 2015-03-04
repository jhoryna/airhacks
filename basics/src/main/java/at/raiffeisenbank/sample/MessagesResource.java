package at.raiffeisenbank.sample;

import java.util.function.Consumer;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Path("messages")
public class MessagesResource {

    @Inject
    Event<Consumer<String>> consumers;

    @GET
    public void all(@Suspended AsyncResponse response) {
        Consumer<String> consumer = response::resume;
        consumers.fire(consumer);

    }

}
