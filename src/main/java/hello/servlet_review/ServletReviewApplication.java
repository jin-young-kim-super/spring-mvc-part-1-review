package hello.servlet_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ServletComponentScan // 서블릿 객체 자동 컨테이너 등록
public class ServletReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletReviewApplication.class, args);
	}


	/**
	 * 아래와 같이 application.properties 설정 정보를 읽어 들여서 스프링 부트가
	 * 아래와 같은 코드로 자동 등록 한다.
	 */

//	@Bean
//	ViewResolver internalResoucrViewResolver() {
//		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
//	}


}
