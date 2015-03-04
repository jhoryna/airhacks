package at.raiffeisenbank;

import java.util.function.Supplier;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class FunctionalTest {

    @Test
    public void functionalInterfaces() {
        Supplier<String> supplier = this::message;
        String result = supplier.get();
        assertThat(result, is("hello"));
    }

    @Test
    public void customFunctionInterface() {
        RLogger LOG = this::log;
        LOG.log("hey joe");
        LOG.msg();
    }

    @Test
    public void async() {
        Runnable run = this::heavyLifting;

        Thread t = new Thread(run);
        t.start();
    }

    public String message() {
        return "hello";
    }

    public void log(String message) {
        System.out.println("--->" + message);
    }

    public void heavyLifting() {
        System.out.println("Very slow method");
    }
}
