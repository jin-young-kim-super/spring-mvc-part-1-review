package hello.servlet_review.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 여기는 Controller
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF : 이 폴더 밑의 리소스는 클라이언트에서 직접 호출해도 응답 안됨
        // -> 반드시 컨트롤러를 거치고 JSP 파일을 응답하고 싶을 때에는 WEB-INF 밑에 JSP 파일을 두면 된다.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // forward : 다른 서블릿 객체나 jsp 파일로 이동!(서버 내부에서 이동)
        // redirect vs forward : redirect는 일단 클라이언트에 응답이 한 번 나간다.
        dispatcher.forward(request,response);
    }
}
