package at.raiffeisenbank.customer.boundary;

import at.raiffeisenbank.customer.entity.Customer;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Interceptors({InvocationAudit.class})
public class CustomerManager {

    public Customer get(long id, String name, boolean active) {
        return new Customer(id, name, active);
    }
}
