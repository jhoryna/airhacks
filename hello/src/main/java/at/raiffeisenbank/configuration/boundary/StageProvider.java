package at.raiffeisenbank.configuration.boundary;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class StageProvider {

    @Produces
    public Stage expose() {
        return Stage.DEV;
    }

}
