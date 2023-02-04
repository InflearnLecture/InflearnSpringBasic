package com.example.inflearnbasic;

import com.example.inflearnbasic.memeber.Grade;
import com.example.inflearnbasic.memeber.Member;
import com.example.inflearnbasic.memeber.MemberService;
import com.example.inflearnbasic.memeber.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {


    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();   //이제 얘네 주석처리하고 스프링 사용해보자
//        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        //스프링은 모든게 ApplicationContext에서 시작. 이게 스프링 컨테이너 @Bean 객체 관리
        //AnnotationConfigApplicationContext();을 만들어 줘야함! 파라미터로는 AppConfig.class 우리가 썼던..
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이름 memberService인 객체 빈 꺼내올거임. 타입은 MemberService.class
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
