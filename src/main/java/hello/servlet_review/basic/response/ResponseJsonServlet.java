package hello.servlet_review.basic.response;

import hello.servlet_review.basic.HelloData;
import hello.servlet_review.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;


@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        // result : "{username : "kim", age : 20}"
        // -> JSON은 단순히 하나의 문자열이기에 HTTP BODY에 하나의 문자열 형태로 들어간다.
        // 다만, Content-Type이 application/json으로 설정하면 웹 브라우저가 문자열을 JSON 형태로 파싱한다.
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);



    }
}
