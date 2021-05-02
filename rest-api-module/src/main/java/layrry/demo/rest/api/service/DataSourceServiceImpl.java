
package layrry.demo.rest.api.service;

import com.querydsl.core.types.Predicate;
import layrry.demo.rest.api.model.DataSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class DataSourceServiceImpl implements DataSourceService {


    /**
     * dataSourceDao.
     */
    protected DataSourceDAO dataSourceDao;

    /**
     * Constructor.
     *
     * @param dataSourceDao the datasource dao service
     */
    public DataSourceServiceImpl(DataSourceDAO dataSourceDao) {
        this.dataSourceDao = dataSourceDao;
    }

    /**
     * Get the DataSource from the DataSource repository.
     *
     * @param id id of the DataSource
     * @return the DataSource if exists, or Optional.empty()
     */
    public Optional<DataSource> getDataSourceById(Long id) {
        Objects.requireNonNull(id, "id should not be null");
        return this.dataSourceDao.findById(id);
    }

    /**
     * Get the list of dataSource (paginated results).
     *
     * @return List : the list of the dataSource in the database or an empty list if database is empty
     */
    public List<DataSource> getAllDataSources() {
        return (List<DataSource>) this.dataSourceDao.findAll();
    }


    /**
     * Create a new DataSource.
     *
     * @param dataSource the definition of the DataSource to create
     * @return created dataSource. Original dataSource with some fields updated (e.g. id)
     */
    public DataSource createDataSource(@NotNull @Valid DataSource dataSource) {
        return this.dataSourceDao.save(dataSource);
    }


    /**
     * Delete an dataSource from the repository.
     *
     * @param id id of the dataSource
     */
    public void deleteDataSource(@Valid @NotNull Long id) {
        this.dataSourceDao.deleteById(id);
    }

}
