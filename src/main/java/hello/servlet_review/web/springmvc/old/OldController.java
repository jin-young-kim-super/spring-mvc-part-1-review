package hello.servlet_review.web.springmvc.old;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 초창기 springMVC는 @Controller [에노테이션]이 아닌, Controller [인터페이스]를 상속시켜서 핸들러(컨트롤러)를 구현했다
 * -> 이떄에는 [key,핸들러 객체] = [스프링 빈 이름, 컨트롤러]의 형태로 핸들러(컨트롤러) 리스트에 등록이 됐다.
 * 그리고 당연히 이 핸들러를 찾을 수 있는 [핸들러 매퍼]와 이 핸들러를 실행시킬 수있는 [핸들러 어댑터]도 따로 필요하다.
 * 스프링부트는 이 2가지를 미리 구현을 해 놓아서, DispatcherServlet에 등록을 해 놓는다.
 *
 * 정리 : 초기 SpringMVC의 핵심 -> 스프링 빈 이름으로 컨트롤러를 찾는다(이떄,BeanNamedURlHandlerMapping이라는 핸들러 매핑으로 컨트럴러 탐색)
 * -> 고로 아래처럼 스프링 빈 이름을 URL로 설정해 놓는다. 그러면 BeanNamedURlHandlerMapping이 해당 핸들러를 탐색한다
 * 탐색이 끝나면, SimpleControllerHandlerAdapter가 handleRequest 메서드를 호출한다.
 */

// @Component를 통해서 URL을 스프링 빈 이름으로 등록
// -> 물론, 이 컨트롤러는 스프링 부트가 자동으로 DispatcherServlet에 등록한다.
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
