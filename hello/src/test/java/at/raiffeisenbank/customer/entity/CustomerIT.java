package at.raiffeisenbank.customer.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CustomerIT {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEM() {
        this.em = Persistence.
                createEntityManagerFactory("it").
                createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void crud() {
        this.tx.begin();
        this.em.persist(new Customer(42, "hugo", true));
        this.tx.commit();
    }

    @Test
    public void allQuery() {
        this.tx.begin();
        final Customer expected = new Customer(System.currentTimeMillis(), "hugo", true);
        this.em.persist(expected);
        this.tx.commit();

        List<Customer> customers = this.em.createNamedQuery("all", Customer.class).getResultList();
        assertThat(customers, hasItem(expected));
    }

}
