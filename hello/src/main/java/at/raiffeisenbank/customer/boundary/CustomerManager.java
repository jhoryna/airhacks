package at.raiffeisenbank.customer.boundary;

import at.raiffeisenbank.customer.control.CustomerValidator;
import at.raiffeisenbank.customer.entity.Customer;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Interceptors({InvocationAudit.class})
public class CustomerManager {

    @Inject
    CustomerValidator cv;

    public Customer get(long id, String name, boolean active) {
        Customer customer = new Customer(id, name, active);
        if (!cv.isValid(customer)) {
            throw new IllegalStateException("Invalid!");
        }
        return customer;
    }
}
