package at.raiffeisenbank.sample;

import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class Messenger {

    public void hello(@Observes Consumer<String> sink) {
        sink.accept("hello disfunctional morning");
    }

}
