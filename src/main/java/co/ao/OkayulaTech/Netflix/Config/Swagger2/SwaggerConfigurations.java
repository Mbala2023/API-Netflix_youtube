package co.ao.OkayulaTech.Netflix.Config.Swagger2;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfigurations {	
	
	@Bean
	public Docket Netflix()
	{		
		
 		 return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("co.ao.OkayulaTech.Netflix"))
				.paths(PathSelectors.any())
				.build()
				.ignoredParameterTypes(Usuario.class)
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
						.name("Authorization")                    
						.description("Header para token JWT")       
						.modelRef(new ModelRef("string"))       
						.parameterType("header")
						.required(false)
						.build()));		        
 		 
 		 
	}
	

	
}
