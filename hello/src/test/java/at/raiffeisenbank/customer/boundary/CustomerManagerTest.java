package at.raiffeisenbank.customer.boundary;

import at.raiffeisenbank.customer.control.CustomerValidator;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author airhacks.com
 */
public class CustomerManagerTest {

    CustomerManager cut;

    @Before
    public void init() {
        this.cut = new CustomerManager();
        this.cut.cv = mock(CustomerValidator.class);
    }

    @Test(expected = IllegalStateException.class)
    public void invalidCustomer() {
        when(this.cut.cv.isValid(anyObject())).thenReturn(false);
        this.cut.get(2, "hugo", true);
    }

}
