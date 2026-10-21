package hello.servlet_review.web.frontcontroller.v4.controller;

import hello.servlet_review.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        /**
         * ModelView 생성 안 하고, 뷰 이름만 반환
         */
        return "new-form";
    }
}
