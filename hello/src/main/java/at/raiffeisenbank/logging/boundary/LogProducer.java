package at.raiffeisenbank.logging.boundary;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class LogProducer {

    @Produces
    public Logger expose(InjectionPoint ip) {
        String clazz = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(clazz);
    }

}
