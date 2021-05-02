
package layrry.demo.rest.api.service;

import layrry.demo.rest.api.model.DataSource;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The Interface DataSourceDAO.
 */
public interface DataSourceDAO extends PagingAndSortingRepository<DataSource, Long>,
        QuerydslPredicateExecutor<DataSource> {
}
