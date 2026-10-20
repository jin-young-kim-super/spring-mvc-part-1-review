package hello.servlet_review.web.frontcontroller.v2.controller;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;
import hello.servlet_review.web.frontcontroller.MyView;
import hello.servlet_review.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> allMembers = memberRepository.findAll();

        // Model
        request.setAttribute("members",allMembers);

        String viewPath ="/WEB-INF/views/members.jsp";
        return new MyView(viewPath);
    }
}
