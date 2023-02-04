package com.example.inflearnbasic.memeber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

/*    private final MemberRepository memberRepository = new MemoryMemberRepository();*/
    private final MemberRepository memberRepository;

    @Autowired // 자동의존관계 주입.. 생성자에다가 붙히면 멤버리파지토리 타입에 맞는 애를 알아서 끌어와서 의존관계 주입 해주는 . .
    //컴포넌트스캔으로 빈 등록하려면 오토와이어드 쓰게 됨 .. 그외에 뭐 수동으로 주입할 수 없으니
    //ac.getBean(MemberRepository.class) 이런 느낌?
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
//설계변경으로 MemberServiceImpl은 MemoryMemberRepository를 의존하지 않는다!
//단지 MemberRepository 인터페이스만 의존한다!
//MemberServiceImpl입장에서 생성자 통해 어떤 구현 객체가 들어올지(주입될지) 알 수 없다
//MemberServiceImpl의 생성자를 통해 어떤 구현 객체 주입할지는 외부(AppConfig)에서 결정된다
//MemberServiceImpl은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다!