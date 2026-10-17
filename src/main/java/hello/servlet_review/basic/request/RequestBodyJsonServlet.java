package hello.servlet_review.basic.request;

import hello.servlet_review.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**클라이언트에서 보내는 메세지 타입을 설정해서 전송한다는 가정!
 * Content-type : application/json
 */
@WebServlet(name="requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    // ObjectMapper : 스프링부트가 기본 내장하고 있는 JSON 변환 객체(패키지 경로 : tools.jackson.databind.ObjectMapper)
    // -> 정확히는 스프링 MVC를 사용하면 스프링 부트가 JACKSON 라이브러리를 자동 내포한다
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();
        // 이 시점에서는 단순한 하나의 문자열 형태(JSON도 결국 하나의 문자열에 불과)
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());


    }
}
