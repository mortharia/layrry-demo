import layrry.demo.rest.api.internal.DemoPluginLifecycleListener;
import layrry.demo.provider.api.service.ApiDAOFactory;
import org.moditect.layrry.platform.PluginLifecycleListener;

module layrry.demo.rest.api {


    requires layrry.demo.provider.api;
    requires org.moditect.layrry.platform;


    requires java.annotation;
    requires java.persistence;
    requires java.validation;

    requires org.apache.commons.lang3;

    requires org.hibernate.validator;



    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.data.jpa;
    requires spring.context;
    requires spring.core;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.jcl;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;

    requires querydsl.core;




    exports layrry.demo.rest.api;
    exports layrry.demo.rest.api.model;
    exports layrry.demo.rest.api.model.dto;
    exports layrry.demo.rest.api.error;
    exports layrry.demo.rest.api.service;


    opens layrry.demo.rest.api;
    opens layrry.demo.rest.api.model;
    opens layrry.demo.rest.api.model.dto;
    opens layrry.demo.rest.api.error;
    opens layrry.demo.rest.api.service;

    provides PluginLifecycleListener with DemoPluginLifecycleListener;
    uses ApiDAOFactory;
}
