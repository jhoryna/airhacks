package at.raiffeisenbank.customer.boundary;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("customers")
public class CustomersResource {

    @Inject
    CustomerManager cm;

    @GET
    public JsonArray all() {
        return Json.createArrayBuilder().add("duke").add("hugo").build();
    }

    @GET
    @Path("{id}")
    public Response customer(@PathParam("id") long id) {
        return Response.ok(cm.get(id, "hugo", true)).
                header("x-status", "gold").build();
    }

    @POST
    public Response save(@Context UriInfo info, @Size(min = 2, max = 5) String customer) {
        System.out.println("customer = " + customer);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(uri).build();
    }

}
