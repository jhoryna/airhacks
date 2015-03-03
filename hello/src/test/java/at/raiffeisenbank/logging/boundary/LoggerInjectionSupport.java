package at.raiffeisenbank.logging.boundary;

import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class LoggerInjectionSupport {

    @Inject
    Logger LOG;

    public Logger getLOG() {
        return LOG;
    }

}
