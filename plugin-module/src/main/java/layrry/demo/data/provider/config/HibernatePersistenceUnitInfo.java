
package layrry.demo.data.provider.config;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class HibernatePersistenceUnitInfo implements PersistenceUnitInfo {
    /**
     * JPA version.
     */
    public static final String JPA_VERSION = "2.1";
    /**
     * The persistence Unit Name.
     */
    private final String persistenceUnitName;
    /**
     * The transaction Type.
     */
    private PersistenceUnitTransactionType transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
    /**
     * The managed entity classes.
     */
    private final List<String> managedClassNames;
    /**
     * The mapping File Names for the entity classes mapping.
     */
    private final List<String> mappingFileNames = new ArrayList<>();
    /**
     * Hibernate properties.
     */
    private final Properties properties;
    /**
     * The JTA (Jakarta Transactions) datasource.
     */
    private DataSource jtaDataSource;
    /**
     * The non-JTA datasource.
     */
    private DataSource nonjtaDataSource;
    /**
     * The transformer for every new class definition or class.
     */
    private final List<ClassTransformer> transformers = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param persistenceUnitName the persistenceUnitName
     * @param managedClassNames   the managedClassNames
     * @param properties          the properties list
     */
    public HibernatePersistenceUnitInfo(String persistenceUnitName,
                                        List<String> managedClassNames, Properties properties) {
        this.persistenceUnitName = persistenceUnitName;
        this.managedClassNames = managedClassNames;
        this.properties = properties;
    }

    @Override
    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return HibernatePersistenceProvider.class.getName();
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Set the JTA dataSource.
     *
     * @param jtaDataSource the JTA datasource
     * @return the HibernatePersistenceUnitInfo
     */
    public HibernatePersistenceUnitInfo setJtaDataSource(DataSource jtaDataSource) {
        this.jtaDataSource = jtaDataSource;
        this.nonjtaDataSource = null;
        transactionType = PersistenceUnitTransactionType.JTA;
        return this;
    }

    @Override
    public DataSource getJtaDataSource() {
        return jtaDataSource;
    }

    /**
     * Set the non-JTA dataSource.
     *
     * @param nonJtaDataSource the non-JTA datasource
     * @return teh HibernatePersistenceUnitInfo
     */
    public HibernatePersistenceUnitInfo setNonJtaDataSource(DataSource nonJtaDataSource) {
        this.nonjtaDataSource = nonJtaDataSource;
        this.jtaDataSource = null;
        transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
        return this;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return nonjtaDataSource;
    }

    @Override
    public List<String> getMappingFileNames() {
        return mappingFileNames;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return Collections.emptyList();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return managedClassNames;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return SharedCacheMode.UNSPECIFIED;
    }

    @Override
    public ValidationMode getValidationMode() {
        return ValidationMode.AUTO;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return JPA_VERSION;
    }

    @Override
    public ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {
        transformers.add(transformer);
    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
