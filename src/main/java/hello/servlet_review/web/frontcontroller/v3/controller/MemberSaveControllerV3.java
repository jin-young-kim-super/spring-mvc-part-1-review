package hello.servlet_review.web.frontcontroller.v3.controller;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;
import hello.servlet_review.web.frontcontroller.ModelView;
import hello.servlet_review.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        Member savedMember = memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member",savedMember);
        return modelView;

    }
}
