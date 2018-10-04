package API;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import main.ItemControllers;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = ItemControllers.class)
class SwaggerAPI{
	
	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICESE = "licanse";
	private static final String title = "products REST API";
	private static final String description = "RESTful API for Products";
	
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICESE)
				.version(SWAGGER_API_VERSION)
				.build();
	}
	
	
	@Bean
	public Docket itemApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		
	}
}