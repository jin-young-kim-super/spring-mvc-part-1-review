package hello.servlet_review.web.springmvc.v1;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SpringMemberListControllerV1 {


    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {

        List<Member> allMembers = memberRepository.findAll();

        ModelAndView modelView = new ModelAndView("members");
        modelView.addObject("members",allMembers);
        return modelView;

    }
}
