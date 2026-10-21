package hello.servlet_review.web.frontcontroller.v3.controller;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;
import hello.servlet_review.web.frontcontroller.ModelView;
import hello.servlet_review.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> allMembers = memberRepository.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members",allMembers);
        return modelView;

    }
}
