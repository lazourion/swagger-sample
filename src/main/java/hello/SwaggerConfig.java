package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.description}")
    private String descriptionPath;

    ApiInfo apiInfo() {

       // byte[] encoded = new byte[0];
//        try {
//            encoded = Files.readAllBytes(Paths.get("description.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String description = null;
        try {
            description = new String(Files.readAllBytes(Paths.get(descriptionPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ApiInfoBuilder()
                .title("Swagger sample config!!!")
                .description(description)
                //.description("**Yum application, order food daily from the best chef in town**  This API is used by the angular.io client, and is not meant to be used otherwise.  Find source code of this API [here](http://gitlab/)  Copyright (C) 2017 JR Technologies. ")
                .license("GPLv3")
                .licenseUrl("http://www.gnu.org/licenses/")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("","", ""))
                .build();
    }

//    @Bean
//    public Docket customImplementation(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.jrtechnologies.yum.api"))
//                .build()
//                .apiInfo(apiInfo());
//    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("hello.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}