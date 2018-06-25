package br.uaijug.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig   {

    @Value("${microservice.title}")
    private String title ;
    @Value("${microservice.description}")
    private String description ;
    @Value("${microservice.version}")
    private String version ;
    @Value("${microservice.termsOfServiceUrl}")
    private String termsOfServiceUrl ;
    @Value("${microservice.contact.name}")
    private String contactName ;
    @Value("${microservice.contact.website}")
    private String contactWebsite ;
    @Value("${microservice.contact.email}")
    private String contactEmail ;
    @Value("${microservice.license.name}")
    private String licenseName ;
    @Value("${microservice.license.website}")
    private String licenseWebsite ;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
		.apis(RequestHandlerSelectors.basePackage("br.uaijug.service"))
                .build()
                .apiInfo(
                		new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .termsOfServiceUrl(termsOfServiceUrl)
                        .contact(
                            new Contact(
                            		contactName,
                            		contactWebsite,
                            		contactEmail
                            )
                        )
                        .license(licenseName)
                        .licenseUrl(licenseWebsite)
                        .version(version)
                        .build());
    }
}
