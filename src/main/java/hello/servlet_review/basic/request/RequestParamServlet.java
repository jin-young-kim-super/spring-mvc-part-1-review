package hello.servlet_review.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - START");
        // 모든 GET-쿼리 스트링 조회(form 내부도 조회 가능)
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - END");
        System.out.println();


        System.out.println("[단일 파라미터 조회] - START");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - END");
        System.out.println();

        // ex) http://localhost:8080/request-param?username=hello&age=20&username=kim
        System.out.println("[이름이 같은 파라미터들 조회] - START");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("[이름이 같은 파라미터들 조회] - END");
        System.out.println();
    }
}