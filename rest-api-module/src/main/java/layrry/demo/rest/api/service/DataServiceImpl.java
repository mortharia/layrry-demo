
package layrry.demo.rest.api.service;

import layrry.demo.provider.api.service.PluginDAO;
import layrry.demo.rest.api.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * DataService implementation.
 */
@Service
public class DataServiceImpl extends AbstractDataService implements DataService {

    /**
     * The logging parameter.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceImpl.class);

    /**
     * Constructor.
     *
     * @param apiDAOFactoryLoader The API DAO Factory Loader.
     */
    public DataServiceImpl(ApiPluginServiceLoader apiDAOFactoryLoader) {
        super(apiDAOFactoryLoader);
    }


    @Override
    public void displayLog(String logs) {

        LOGGER.info("Logs displayed by the rest module " + logs +"modules "+ DemoApplication.class.getModule().getLayer().modules());

        PluginDAO dao = (PluginDAO) getServiceDaoFactory("H2").getApiDAO();
        dao.displayLogs(logs);

    }


}
