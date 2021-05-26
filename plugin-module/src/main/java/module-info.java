import layrry.demo.provider.api.service.ApiDAOFactory;
import layrry.demo.data.provider.service.DataPluginDAOFactory;

module layrry.demo.data.provider {
    requires layrry.demo.provider.api;

    requires org.slf4j;

    exports layrry.demo.data.provider.service;

    opens layrry.demo.data.provider.service;


    provides ApiDAOFactory with DataPluginDAOFactory;
}
