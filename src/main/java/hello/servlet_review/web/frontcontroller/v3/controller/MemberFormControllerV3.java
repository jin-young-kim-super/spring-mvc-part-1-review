package hello.servlet_review.web.frontcontroller.v3.controller;

import hello.servlet_review.web.frontcontroller.ModelView;
import hello.servlet_review.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {


    @Override
    public ModelView process(Map<String, String> paramMap) {
        /**
         * V3 버전은 좋지만, 단 1개, 즉 개발자가 각 컨트롤러에서 항상 ModelAndView 생성해서 반환해야 한다는 번거로움이 있다.
         * -> V4 버전은 이런 점을 개선한 것이다.
         */

        return new ModelView("new-form");

    }
}
