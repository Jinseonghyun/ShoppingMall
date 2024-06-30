package shop.shoppingmall.Service;


import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shop.shoppingmall.domain.Member;
import shop.shoppingmall.repository.MemberRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 기본적으로 test마다 rollback을 해서 insert가 안보인다.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(false) // 등록쿼리 볼수있다.
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        //em.flush(); // flush 랑 영속성 컨텍스트에 있는 어떤 변경이나 등록 내용을 데이터 베이스에 반영
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); // 위의 expected로 아래 코드 생략가능

//        try {
//            memberService.join(member2); // 중복 이름 예외 발생해야함
//        } catch (IllegalStateException e) {
//            return;
//        }

        //then
        fail("예외가 발생해야 한다.");

    }
}