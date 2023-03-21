package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService memberService = new MemberService();


    @Test
    void 회원가입() {
        //given : 기반 데이터
        Member member = new Member();
        member.setName("hello");

        //when : 검증하는 것
        Long saveId = memberService.join(member);

        //then : 검증 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    public void 중복_회원_예외() {

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}