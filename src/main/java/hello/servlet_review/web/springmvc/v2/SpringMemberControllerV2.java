package hello.servlet_review.web.springmvc.v2;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 스프링 컨트롤러의 통합
 * -> @RequestMapping에 서로 다른 URL 지정이 가능하기에 통합 가능
 *
**/

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        Member savedMember = memberRepository.save(member);

        ModelAndView modelView = new ModelAndView("save-result");
        modelView.addObject("member",savedMember);
        return modelView;

    }

    @RequestMapping
    public ModelAndView list() {

        List<Member> allMembers = memberRepository.findAll();

        ModelAndView modelView = new ModelAndView("members");
        modelView.addObject("members",allMembers);
        return modelView;

    }
}
