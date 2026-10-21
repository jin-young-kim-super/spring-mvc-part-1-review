package hello.servlet_review.web.frontcontroller.v3;

import hello.servlet_review.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String,String> paramMap);

}
