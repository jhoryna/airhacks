package at.raiffeisenbank.business.sample;

import at.raiffeisenbank.business.logger.Journal;
import at.raiffeisenbank.business.logger.Level;
import java.util.function.Consumer;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class MessageProvider {

    @Inject
    @Journal
    Consumer<String> LOG;

    @Inject
    @Level(Level.Name.DEBUG)
    Consumer<String> DEBUG;

    public String message() {
        LOG.accept("seems to work");
        DEBUG.accept("does not work");
        return "function, async morning from pipeline";
    }

}
