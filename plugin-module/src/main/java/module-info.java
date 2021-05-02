import layrry.demo.provider.api.service.ApiDAOFactory;
import layrry.demo.data.provider.service.DataPluginDAOFactory;

module layrry.demo.data.provider {
    requires layrry.demo.provider.api;

    requires com.h2database;

    requires java.sql;
    requires java.annotation;
    requires java.persistence;
    requires java.validation;

    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;

    requires querydsl.core;
    requires org.hibernate.orm.core;



    exports layrry.demo.data.provider.model;
    exports layrry.demo.data.provider.service;


    opens layrry.demo.data.provider.model;
    opens layrry.demo.data.provider.service;


    provides ApiDAOFactory with DataPluginDAOFactory;
}
