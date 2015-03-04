package at.raiffeisenbank.sample;

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

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.resume("hey joe");

    }

}
