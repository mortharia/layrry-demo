

package layrry.demo.data.provider.service;

import layrry.demo.provider.api.service.ApiDAO;
import layrry.demo.provider.api.service.PluginDAOFactory;

/**
 *  Data PluginDAOFactory implementation class.
 */
public class DataPluginDAOFactory implements PluginDAOFactory {
    @Override
    public ApiDAO getApiDAO() {
        return new DataPluginDAO();
    }

}
