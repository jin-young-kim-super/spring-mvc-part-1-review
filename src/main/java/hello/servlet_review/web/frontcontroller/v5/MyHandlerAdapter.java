package hello.servlet_review.web.frontcontroller.v5;

import hello.servlet_review.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object Handler);

    // 실제 컨트롤러 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
