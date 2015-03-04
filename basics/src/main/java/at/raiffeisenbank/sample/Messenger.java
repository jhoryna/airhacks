package at.raiffeisenbank.sample;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class Messenger {

    @Inject
    MessageProvider provider;

    @Resource
    ManagedExecutorService mes;

    public void hello(@Observes Consumer<String> sink) {
        Supplier<String> supplier = provider::message;
        CompletableFuture.supplyAsync(supplier, mes).thenAccept(sink);
    }

}
