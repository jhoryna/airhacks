package at.raiffeisenbank.customer.boundary;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CustomersResourceIT {

    private WebTarget tut;

    @Before
    public void init() {
        Client client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/hello/resources/customers/");
    }

    @Test
    public void getCustomer() {
        Response response = this.tut.path("42").request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonObject customer = response.readEntity(JsonObject.class);
        System.out.println("customer = " + customer);
        long id = customer.getJsonNumber("id").longValue();
        assertTrue(id != 0);

    }

}
