package com.tudarmstadt.demo.Configuration;

import com.tudarmstadt.demo.controller.ElasticController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import com.google.common.base.Predicate;

import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;
//import static com.google.common.base.Predicates.or;

@Configuration
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = ElasticController.class)
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License";
    private static final String title = "Elastic Search REST API";
    private static final String description = "API reference for developers";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }


    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/search.*"))
                .build();
    }

//    @Bean
//    public Docket postsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("public-api")
//                .apiInfo(apiInfo())
//                .select()
//                .paths(postPaths())
//                .build();
//    }
//
//    private Predicate<String> postPaths() {
//        return or(regex("/api/posts.*"), regex("/text.*"));
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Elastic Search API")
//                .description("API reference for developers")
//                .termsOfServiceUrl("http://javainuse.com")
//                .licenseUrl("javainuse@gmail.com").version("1.0").build();
//    }
}
