package at.raiffeisenbank.business.sample;

import javax.enterprise.inject.Specializes;

/**
 *
 * @author airhacks.com
 */
@Specializes
public class SpecialMessageProvider extends MessageProvider {

    @Override
    public String message() {
        return "specialized " + super.message();
    }

}
