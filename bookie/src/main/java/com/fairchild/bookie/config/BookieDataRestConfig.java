package com.fairchild.bookie.config;

import com.fairchild.bookie.entity.Book;
import com.fairchild.bookie.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class BookieDataRestConfig implements RepositoryRestConfigurer {

    private String allowedOrigins = "http://localhost:3000";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.PUT,
                HttpMethod.DELETE};

        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);

        disableHttpMethods(Book.class, config, unsupportedActions);
        disableHttpMethods(Review.class, config, unsupportedActions);

        // configure cors mapping
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(allowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) ->
                        httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods.disable(unsupportedActions));

    }


}
