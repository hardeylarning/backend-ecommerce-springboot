package com.rochtech.ecommerce.config;

import com.rochtech.ecommerce.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    // TODO: 29/10/2021 if not work
    // TODO: 29/10/2021 for id exposition

    @Value("${allowed.origins}")
    private String [] allowedOrigins;

    @Autowired
    EntityManager entityManager;


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] disableActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH};

        //
        disAbleHttpMethod(Product.class,config, disableActions);

        disAbleHttpMethod(ProductCategory.class,config, disableActions);

        //
        disAbleHttpMethod(Country.class,config, disableActions);
        disAbleHttpMethod(State.class,config, disableActions);

        // disable order configuration
        disAbleHttpMethod(Order.class,config, disableActions);

        // expose ids in spring data rest
        exposeIds(config);

        // configure cors mapping
        cors.addMapping(config.getBasePath() +"/**").allowedOrigins(allowedOrigins);
    }

    private void disAbleHttpMethod(Class theClass , RepositoryRestConfiguration config, HttpMethod[] disableActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(disableActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(disableActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType e: entityTypes) {
            entityClasses.add(e.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
