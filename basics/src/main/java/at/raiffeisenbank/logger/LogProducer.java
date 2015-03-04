package at.raiffeisenbank.logger;

import java.util.function.Consumer;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class LogProducer {

    @Produces
    @Journal
    public Consumer<String> expose(InjectionPoint ip) {
        String clazz = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(clazz)::info;
    }

    @Produces
    @Level(Level.Name.DEBUG)
    public Consumer<String> log(InjectionPoint ip) {
        String clazz = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(clazz)::warning;
    }

}
