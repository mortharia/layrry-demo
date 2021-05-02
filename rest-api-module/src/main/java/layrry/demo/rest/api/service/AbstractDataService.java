

package layrry.demo.rest.api.service;

import layrry.demo.provider.api.service.ApiDAOFactory;

import java.util.List;

/**
 * Abstract Data Service that handle DAOs and the business logic.
 *
 */
public abstract class AbstractDataService {

    /**
     * The DataSourceService.
     */
    protected ApiPluginServiceLoader apiDAOFactoryLoader;

    /**
     * Constructor.
     *
     * @param apiDAOFactoryLoader The API DAO Factory Loader.
     */
    public AbstractDataService(ApiPluginServiceLoader apiDAOFactoryLoader) {
        this.apiDAOFactoryLoader = apiDAOFactoryLoader;
    }


    /**
     * Get the service DAO implementation for a data source type.
     *
     * @param type the ApiDAOFactory service type.
     * @return the T service implementation
     */
    public ApiDAOFactory getServiceDaoFactory(String type) {

        List<ApiDAOFactory> dsDAOFactories =
                this.apiDAOFactoryLoader.getDSPluginService(type);

        if (dsDAOFactories.isEmpty()) {
            throw new UnsupportedOperationException("No service DAO implementation found for this"
                    + " data source connector : " + type);
        }

        return dsDAOFactories.get(0);

    }


}
