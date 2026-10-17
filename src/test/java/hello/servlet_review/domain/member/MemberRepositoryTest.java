package hello.servlet_review.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member kim = new Member("kim", 20);

        //when
        Member savedMember = memberRepository.save(kim);

        //then
        Member findedMember = memberRepository.findById(savedMember.getId());
        assertThat(findedMember).isSameAs(savedMember);

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("kim1", 20);
        Member member2 = new Member("kim2", 30);
        Member member3 = new Member("kim3", 40);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        //when
        List<Member> allMembers = memberRepository.findAll();

        //then
        assertThat(allMembers.size()).isEqualTo(3);
        assertThat(allMembers).contains(member1,member2,member3);
    }
}