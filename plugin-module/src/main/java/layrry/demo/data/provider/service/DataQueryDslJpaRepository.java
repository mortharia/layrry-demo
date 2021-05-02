
package layrry.demo.data.provider.service;

import layrry.demo.data.provider.config.JpaEntityManagerFactory;
import layrry.demo.data.provider.config.SQLDatabaseConfig;
import layrry.demo.data.provider.model.Data;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DataQueryDslJpaRepository extends QueryDslSimpleJpaRepositoryImpl<Data, Long> {

    /**
     * Constructor.
     *
     * @param configuration
     */
    public DataQueryDslJpaRepository(String configuration) {
        this(getJpaEntityManager(configuration));
    }

    private DataQueryDslJpaRepository(EntityManager entityManager) {
        super(getJpaEntityInformation(entityManager), entityManager);
    }


    private static EntityManager getJpaEntityManager(String configuration) {
        return new JpaEntityManagerFactory(
                new Class[]{Data.class}, SQLDatabaseConfig.getProperties(configuration)).getEntityManager();
    }


    private static JpaEntityInformation<Data, ?> getJpaEntityInformation(EntityManager entityManager) {
        return JpaEntityInformationSupport.getEntityInformation(Data.class, entityManager);
    }

    /**
     * Get the EntityManager transaction.
     * @return EntityTransaction
     */
    public EntityTransaction getTransaction() {
        return super.getJpaEntityManager().getTransaction();
    }
}
