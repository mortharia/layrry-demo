

package layrry.demo.rest.api.service;

import layrry.demo.provider.api.service.ApiDAOFactory;
import layrry.demo.rest.api.internal.DemoPluginLifecycleListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;


/**
 * The API plugin service loader class.
 */
@Service
public class ApiPluginServiceLoader {



    /**
     * Get the ApiDAOFactory service subtype implementation for a data source plugin type.
     *
     * @param type    the data source plugin type.
     * @return List of ApiDAOFactory implementations.
     */
    public List<ApiDAOFactory> getDSPluginService(String type) {
        /**
         * List of DAO service implementations of T class.
         */
        List<ApiDAOFactory> apiDAOFactories = new ArrayList<>();

        for (Map.Entry<String, ModuleLayer> layer : DemoPluginLifecycleListener.getModuleLayers().entrySet()) {
            ServiceLoader.load(layer.getValue(), ApiDAOFactory.class)
                    .stream()
                    .map(ServiceLoader.Provider::get)
                    .filter(d -> d.getApiDAO().accept(type))
                    .forEach(apiDAOFactories::add);
        }

        return apiDAOFactories;
    }

}
