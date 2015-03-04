package at.raiffeisenbank;

import java.util.function.Supplier;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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

    @Test
    public void asyncJs() throws ScriptException {
        Runnable run = get();
        run.run();
    }

    public Runnable get() throws ScriptException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        Invocable i = (Invocable) engine;

        engine.eval("function run(){ print('running in js');}");
        return i.getInterface(Runnable.class);

    }

}
