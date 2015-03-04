package at.raiffeisenbank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class StreamTest {

    @Test
    public void streaming() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("duke", 10));
        customers.add(new Customer("hugo", 42));
        customers.add(new Customer("scala", 2));

        double averageAge = customers.parallelStream().
                filter(c -> !c.getName().startsWith("s")).
                mapToInt((customer) -> customer.getAge()).
                average().
                orElse(0);
        System.out.println("averageAge = " + averageAge);

        List<Customer> sCustomers = customers.stream().
                filter(c -> c.getName().startsWith("s")).
                collect(Collectors.toList());
        assertThat(sCustomers.size(), is(1));
    }

}
