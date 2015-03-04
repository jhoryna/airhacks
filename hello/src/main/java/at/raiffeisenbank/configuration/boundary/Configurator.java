package at.raiffeisenbank.configuration.boundary;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Produces
    public String expose(InjectionPoint ip, Stage stage) {
        String clazz = ip.getMember().getDeclaringClass().getName();
        String fieldName = ip.getMember().getName();
        String retVal = stage.name() + "->" + clazz + "." + fieldName;
        System.out.println("retVal = " + retVal);
        return retVal;
    }

}
