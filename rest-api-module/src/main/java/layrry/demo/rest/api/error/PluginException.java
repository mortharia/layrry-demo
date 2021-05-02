
package layrry.demo.rest.api.error;

/**
 * The Plugin exception class.
 */
public class PluginException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param ex : The triggered exception.
     */
    public PluginException(Exception ex) {
        super(ex);
    }
}
