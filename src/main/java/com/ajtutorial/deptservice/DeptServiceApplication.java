package com.ajtutorial.deptservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class DeptServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(DeptServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DeptServiceApplication.class, args);
	}

//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
//				.paths(postPaths()).build();
//	}
//
//	private Predicate<String> postPaths() {
//		return or(regex("/api/v1/dept.*"), regex("/api/javainuse.*"));
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("JavaInUse API").description("JavaInUse API reference for developers")
//				.termsOfServiceUrl("http://javainuse.com").contact("javainuse@gmail.com").license("JavaInUse License")
//				.licenseUrl("javainuse@gmail.com").version("1.0").build();
//	}

}
