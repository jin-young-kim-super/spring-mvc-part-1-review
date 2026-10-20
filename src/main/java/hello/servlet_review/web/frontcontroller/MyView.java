package hello.servlet_review.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * MyView 객체에서 기존에는 각 컨트롤러에서 담당하던 뷰 이동 로직 부분을 담당
 * -> 각 컨트롤러의 뷰 이동 로직 부분 제거(중복 제거, 공통 기능 처리)
 */
public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPath);
        dispatcher.forward(request,response);
    }
}
