import layrry.demo.rest.api.internal.DemoPluginLifecycleListener;
import layrry.demo.provider.api.service.ApiDAOFactory;
import org.moditect.layrry.platform.PluginLifecycleListener;

module layrry.demo.rest.api {


    requires layrry.demo.provider.api;
    requires org.moditect.layrry.platform;


    requires java.annotation;

    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;

    requires org.slf4j;


    exports layrry.demo.rest.api;
    exports layrry.demo.rest.api.service;


    opens layrry.demo.rest.api;
    opens layrry.demo.rest.api.service;

    provides PluginLifecycleListener with DemoPluginLifecycleListener;
    uses ApiDAOFactory;
}
