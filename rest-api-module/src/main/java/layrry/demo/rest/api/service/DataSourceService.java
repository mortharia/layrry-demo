package layrry.demo.rest.api.service;

import com.querydsl.core.types.Predicate;
import layrry.demo.rest.api.model.DataSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * DataSource Interface that contains the business logic to manage DataSource.
 */
public interface DataSourceService {


    /**
     * Get the list of dataSource (paginated results).
     *
     * @return List : the list of the dataSource in the database or an empty list if database is empty
     */
    List<DataSource> getAllDataSources();

    /**
     * Create a new DataSource.
     *
     * @param dataSource the definition of the DataSource to create
     * @return created dataSource. Original dataSource with some fields updated (e.g. id)
     */
    DataSource createDataSource(@NotNull @Valid DataSource dataSource);


    /**
     * Delete an dataSource from the repository.
     *
     * @param id id of the dataSource
     */
    void deleteDataSource(@Valid @NotNull Long id);


    /**
     * Get data source by its id.
     *
     * @param dataSourceId Id of the data source.
     * @return DataSource: The data source.
     */
    Optional<DataSource> getDataSourceById(@NotNull Long dataSourceId);

}
