package com.gustavonascimento.doc;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	
    private ApiInfo informacoesApi() 
    {
    	ApiInfo apiInfo=new ApiInfo("TITLE", "DESC", "1.0", "TERMO", new Contact("g", "gurl", "gemail"), "linceça","url",new ArrayList<>());
    	return apiInfo;
    }
    @Bean
    public Docket detalheApi() 
    {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("com.gustavonascimento.projetoSpring.resources"))
        		.paths(PathSelectors.any())
        		.build()
        		.apiInfo(informacoesApi());
    }
}