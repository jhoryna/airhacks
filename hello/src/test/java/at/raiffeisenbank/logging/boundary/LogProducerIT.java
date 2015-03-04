package at.raiffeisenbank.logging.boundary;

import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(Arquillian.class)
public class LogProducerIT {

    @Inject
    LoggerInjectionSupport cut;

    @Deployment(name = "hugo")
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(LogProducer.class, LoggerInjectionSupport.class).
                addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @OperateOnDeployment("hugo")
    public void logConfigured() {
        String expected = cut.getClass().getName();
        String actual = cut.getLOG().getName();
        assertThat(actual, is(expected));
    }

}
