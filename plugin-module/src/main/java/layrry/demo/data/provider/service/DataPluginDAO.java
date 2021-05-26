

package layrry.demo.data.provider.service;

import layrry.demo.provider.api.service.PluginDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SQL Implementation to manage data entity.
 */

public class DataPluginDAO implements PluginDAO {

    /**
     * The logging parameter.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataPluginDAO.class);


    public static final String DS_CONNECTOR_TYPE = "H2";


    @Override
    public boolean accept(String connectorType) {
        return DS_CONNECTOR_TYPE.equals(connectorType);
    }

    @Override
    public void displayLogs(String logs) {
        LOGGER.info("Logs displayed by the plugin module " + logs);
    }


}

