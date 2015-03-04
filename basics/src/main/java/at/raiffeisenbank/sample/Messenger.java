package at.raiffeisenbank.sample;

import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class Messenger {

    public String hello() {
        return "good morning";
    }

}
