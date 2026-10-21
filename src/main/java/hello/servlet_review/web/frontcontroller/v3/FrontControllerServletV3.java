package hello.servlet_review.web.frontcontroller.v3;

import hello.servlet_review.web.frontcontroller.ModelView;
import hello.servlet_review.web.frontcontroller.MyView;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();


    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerMap.get(requestURI);

        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }

        HashMap<String, String> paramMap = createParamMap(request);
        ModelView modelView = controller.process(paramMap);

        MyView myView = viewResolver(request, response, modelView);
        myView.render(modelView.getModel(), request, response);
    }

    private MyView viewResolver(HttpServletRequest request, HttpServletResponse response, ModelView modelView) throws IOException, ServletException {
        String viewName = modelView.getViewName();
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private  HashMap<String, String> createParamMap(HttpServletRequest request) {
        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(
                 paramName -> paramMap.put(paramName, request.getParameter(paramName))
                );
        return paramMap;
    }
}
