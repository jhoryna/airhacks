package at.raiffeisenbank.customer.entity;

import javax.persistence.Entity;
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
public class Customer {

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
