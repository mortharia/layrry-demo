

package layrry.demo.provider.api.service;

/**
 * API DAO Factory Interface for ApiDAO classes.
 * Connector implementation must provide at least one instance of this interface.
 */
public interface ApiDAOFactory {

    /**
     * Get the ApiDAO instance.
     *
     * @return ApiDAO instance.
     */
    ApiDAO getApiDAO();
}
