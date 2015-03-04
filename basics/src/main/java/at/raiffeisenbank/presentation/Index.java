package at.raiffeisenbank.presentation;

import at.raiffeisenbank.business.sample.Messenger;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    @Inject
    Messenger messenger;

    public String getMessage() {
        return messenger.getMessage();
    }
}
