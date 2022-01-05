package com.vehicle.api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class SwaggerConfig{
        @Bean
        RouterFunction<ServerResponse> routerFunction() {
            return route(GET("/"), request ->
                    ServerResponse.temporaryRedirect(URI.create("/swagger-ui.html"))
                            .build()
            );
        }

        @Bean
        OpenAPI customOpenAPI(BuildProperties buildProperties) {
            Info info = new Info().title("OSM Data Autofixer Service API")
                    .version(buildProperties.getVersion())
                    .description("Application provides functionality to autofix OSM features.");
            return new OpenAPI().components(new Components())
                    .info(info);
        }

        @Bean
        GroupedOpenApi publicApi() {
            return GroupedOpenApi.builder()
                    .group("0 - Public API")
                    .pathsToMatch("/**")
                    .build();
        }
}
