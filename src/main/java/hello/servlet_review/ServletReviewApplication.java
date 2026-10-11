package hello.servlet_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 서블릿 객체 자동 컨테이너 등록
public class ServletReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletReviewApplication.class, args);
	}

}
