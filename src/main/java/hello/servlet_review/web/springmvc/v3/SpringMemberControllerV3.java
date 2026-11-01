package hello.servlet_review.web.springmvc.v3;

import hello.servlet_review.domain.member.Member;
import hello.servlet_review.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


/**
 * Spring의 RequestMappingHandlerAdapter의 확장성에 의해서 여러 Adapter들이 등록돼 있는 것을 이용하여
 * SpringMemberControllerV3의 코드를 줄였다.
 * 참고로 RequestMappingHandlerAdapter는 [반환형/메서드의 파라미터 등]을 보고 어떤 Adapter를 고를지
 * 조회한다.
 */


@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ) {

        Member member = new Member(username, age);
        Member savedMember = memberRepository.save(member);

        model.addAttribute("member",savedMember);
        return "save-result";
    }

    @GetMapping
    public String list(Model model) {

        List<Member> allMembers = memberRepository.findAll();
        model.addAttribute("members",allMembers);
        return "members";
    }
}
