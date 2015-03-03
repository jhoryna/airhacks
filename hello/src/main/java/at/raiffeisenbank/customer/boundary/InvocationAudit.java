package at.raiffeisenbank.customer.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class InvocationAudit {

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        System.out.println("--- " + ic.getMethod());
        return ic.proceed();
    }

}
