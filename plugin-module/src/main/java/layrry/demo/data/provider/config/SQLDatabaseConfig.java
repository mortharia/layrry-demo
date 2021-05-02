
package layrry.demo.data.provider.config;

import java.io.IOException;
import java.util.Properties;

public class SQLDatabaseConfig {

    /**
     * Get SQL database hibernate properties.
     *
     * @param conf the data source configuration.
     * @return the properties
     */
    public static Properties getProperties(String conf) {

        if ("H2".equals(conf)) {
            return getH2Properties(conf);
        }

        if ("OtherDataSourceTYpe".equals(conf)) {
            return getOtherDSProperties(conf);
        }
        return null;

    }

    private static Properties getH2Properties(String conf) {

        Properties pluginProp = new Properties();
        try {
            pluginProp.load(SQLDatabaseConfig.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {

        }
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        setConfProperties(hibernateProperties, "hibernate.connection.url",
                pluginProp.getProperty("data.h2datasource.url"));
        setConfProperties(hibernateProperties, "hibernate.connection.username",
                pluginProp.getProperty("data.h2datasource.username"));
        setConfProperties(hibernateProperties, "hibernate.connection.password",
                pluginProp.getProperty("data.h2datasource.password"));
        setConfProperties(hibernateProperties, "hibernate.hbm2ddl.auto",
                pluginProp.getProperty("data.h2datasource.jpa.hibernate.ddl-auto"));
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.jdbc.time_zone", "UTC");

        return hibernateProperties;
    }


    private static Properties getOtherDSProperties(String conf) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        setConfProperties(hibernateProperties, "hibernate.connection.url", "");
        setConfProperties(hibernateProperties, "hibernate.connection.username", "");
        setConfProperties(hibernateProperties, "hibernate.connection.password", "");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        hibernateProperties.setProperty("hibernate.jdbc.time_zone", "UTC");
        return hibernateProperties;
    }


    private static void setConfProperties(Properties hibernateProperties, String property, String value) {
        if (value != null) {
            hibernateProperties.setProperty(property, value);
        }
    }

}
