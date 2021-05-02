
package layrry.demo.data.provider.config;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class JpaEntityManagerFactory {

    /**
     * The entity classes.
     */
    private final Class[] entityClasses;
    /**
     * The hibernate propetries.
     */
    private Properties properties;
    /**
     * The EntityManageFactory.
     */
    private EntityManagerFactory emf;


    /**
     * Constructor.
     *
     * @param entityClasses the entityClasses
     * @param properties    the properties
     */
    public JpaEntityManagerFactory(Class[] entityClasses, Properties properties) {
        this.entityClasses = entityClasses;
        this.properties = properties;
    }

    /**
     * Get the EntityManager.
     *
     * @return the EntityManager
     */
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            initEntityManagerFactory();
        }
        return emf;
    }

    protected void initEntityManagerFactory() {
        PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo(getClass().getSimpleName());
        Map<String, Object> configuration = new HashMap<>();
        emf = new EntityManagerFactoryBuilderImpl(new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration)
                .build();
    }

    protected HibernatePersistenceUnitInfo getPersistenceUnitInfo(String name) {
        return new HibernatePersistenceUnitInfo(name, getEntityClassNames(), getProperties());
    }

    protected List<String> getEntityClassNames() {
        return Arrays.asList(getEntities())
                .stream()
                .map(Class::getName)
                .collect(Collectors.toList());
    }

    protected Properties getProperties() {
        return properties;
    }

    protected Class[] getEntities() {
        return entityClasses;
    }
}
