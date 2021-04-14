package com.chadreque.software.paisapi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Classe ServletContainer que lida com as solicitações recebidas
 */
@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    //Configuracao de classe que a Jersey busca as anotacoes @Path e ou @Provider
    //para que possam ser registadas.
    public JerseyConfig () {
        register(com.chadreque.software.paisapi.resource.PaisResource.class);
        register(com.chadreque.software.paisapi.exception.NotFoundExceptionHandler.class);
        register(com.chadreque.software.paisapi.exception.AlreadyExistsExceptionHandler.class);
    }
}
