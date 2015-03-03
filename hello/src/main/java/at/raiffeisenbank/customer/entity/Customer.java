package at.raiffeisenbank.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author airhacks.com
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQuery(name = "all", query = "SELECT c FROM Customer c")
public class Customer {

    @Id
    private long id;
    private String name;
    private boolean active;

    public Customer(long id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Customer() {
    }

}
