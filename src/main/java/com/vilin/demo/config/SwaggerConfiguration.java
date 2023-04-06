package com.vilin.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    /**
     * 创建Docket类型对象。并使用spring容器管理。
     * Docket是Swagger中的全局配置对象
     */

    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.OAS_30);

        return docket.apiInfo(createApiInfo())
                .select()
                // 配置扫描路径下的API接口
                .apis(RequestHandlerSelectors.basePackage("com.vilin.demo.controller"))
                // 配置过滤API接口的资源路径
                .paths(PathSelectors.regex("/hello/.*"))
                .build();
    }

    // 配置API文档的基本信息
    private ApiInfo createApiInfo(){
        return new ApiInfoBuilder().title("Swagger Test")
                .description("api first configuration.")
                .contact(new Contact("Leo", "www.vilin.com", "guangyongluo@outlook.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }
}
