
package layrry.demo.rest.api.service;

import com.querydsl.core.types.Predicate;
import layrry.demo.provider.api.service.PluginDAO;
import layrry.demo.rest.api.error.PluginException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;


/**
 * DataService implementation.
 */
@Service
public class DataServiceImpl extends AbstractDataService implements DataService {

    /**
     * Constructor.
     *
     * @param apiDAOFactoryLoader ApiPluginServiceLoader instance.
     */
    public DataServiceImpl(ApiPluginServiceLoader apiDAOFactoryLoader) {
        super(apiDAOFactoryLoader);
    }


    @Override
    public Long getDataCounts(@NotNull String dsConfiguration, Predicate predicate, Pageable page) {

        PluginDAO dao = (PluginDAO) getServiceDaoFactory(dsConfiguration).getApiDAO();
        Long count;
        try {
            count = dao.counts(dsConfiguration, predicate, page);
        } catch (Exception ex) {
            throw new PluginException(ex);
        }
        return count;
    }


}
