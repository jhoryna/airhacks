package at.raiffeisenbank;

/**
 *
 * @author airhacks.com
 */
@FunctionalInterface
public interface RLogger {

    public void log(String message);

    public default void msg() {
        log("nothing");
    }
}
