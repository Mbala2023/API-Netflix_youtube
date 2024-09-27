package co.ao.OkayulaTech.Netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2

public class NetflixApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}

}
