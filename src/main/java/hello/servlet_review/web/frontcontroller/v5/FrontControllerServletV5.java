package hello.servlet_review.web.frontcontroller.v5;

import hello.servlet_review.web.frontcontroller.ModelView;
import hello.servlet_review.web.frontcontroller.MyView;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet_review.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet_review.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet_review.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet_review.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet_review.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servlet_review.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request);

        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);


        ModelView modelView = adapter.handle(request,response,handler);

        MyView myView = viewResolver(modelView.getViewName());
        myView.render(modelView.getModel(), request, response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {

        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if(handlerAdapter.supports(handler)) {
                return  handlerAdapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없음" + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        Object handler = handlerMappingMap.get(requestURI);
        return handler;
    }


    private MyView viewResolver(String viewName)  {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}
