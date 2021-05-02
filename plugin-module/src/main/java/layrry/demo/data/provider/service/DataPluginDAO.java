

package layrry.demo.data.provider.service;

import com.querydsl.core.types.Predicate;
import layrry.demo.provider.api.service.PluginDAO;
import org.springframework.data.domain.Pageable;

/**
 * SQL Implementation to manage data entity.
 */

public class DataPluginDAO implements PluginDAO {

    /**
     * The DataQueryDslJpaRepository.
     */
    DataQueryDslJpaRepository repository;

    /**
     * SQL data source connector type.
     */
    public static final String DS_CONNECTOR_TYPE = "H2";


    @Override
    public boolean accept(String connectorType) {
        return DS_CONNECTOR_TYPE.equals(connectorType);
    }

    @Override
    public long counts(String configuration, Predicate predicate, Pageable page) {
        initDataRepository(configuration);
        long count = repository.count(predicate);
        return count;
    }

    private void initDataRepository(String configuration) {
            repository = new DataQueryDslJpaRepository(configuration);

    }


}

