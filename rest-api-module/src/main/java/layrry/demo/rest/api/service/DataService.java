
package layrry.demo.rest.api.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;

/**
 * The DataService Interface that defines the business logic to manage getting labels from database.
 */
public interface DataService {

    /**
     * Method to get all Data in a datasource.
     *
     * @param dsConfiguration the  data source type to request
     * @param page            pagination information. Uses default Spring serialization (page=, size=, sort=...)
     * @param predicate       predicate to filter data
     * @return number of datasource data
     */
    Long getDataCounts(@NotNull String dsConfiguration, Predicate predicate, Pageable page);


}
