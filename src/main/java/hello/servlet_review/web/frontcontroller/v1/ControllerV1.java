package hello.servlet_review.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 각 컨트롤러들은 인터페이스를 상속 받아, process를 구현하면 된다.(다형성)
 * -> 그럼 프론트 컨트롤러에서 나중에 어떤 컨트롤러를 호출하여도 일관성 있게 그냥 process만 호출하면 된다.
 */

public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
