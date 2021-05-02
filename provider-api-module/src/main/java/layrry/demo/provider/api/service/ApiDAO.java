

package layrry.demo.provider.api.service;

/**
 * Api DAO interface.
 */
public interface ApiDAO {

    /**
     * Check if the data source can be handled by one of the ApiDAO service implementation.
     *
     * @param connectorType : the data source connector type.
     * @return true for success and false when no implementation found.
     */

    boolean accept(String connectorType);

}
