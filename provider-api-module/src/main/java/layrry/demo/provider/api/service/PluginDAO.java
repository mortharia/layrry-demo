
package layrry.demo.provider.api.service;


import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;


/**
 * Plugin data operations DAO.
 */
public interface PluginDAO extends ApiDAO {


    /**
     * Returns a number of  data entities according to a predicate.
     *
     * @param configuration : the data source configuration
     * @param page          : pagination information. Uses default Spring serialization (page=, size=, sort=...)
     * @param predicate     : predicate to filter labels
     * @return List of label found.
     */
    long counts(String configuration, Predicate predicate, Pageable page);

}
