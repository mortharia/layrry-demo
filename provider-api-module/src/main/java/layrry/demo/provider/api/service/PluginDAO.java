
package layrry.demo.provider.api.service;


/**
 * Plugin data operations DAO.
 */
public interface PluginDAO extends ApiDAO {


    /**
     * Display logs
     *
     * @param logs : the logs to dispaly source configuration
     */
    void displayLogs(String logs);

}
