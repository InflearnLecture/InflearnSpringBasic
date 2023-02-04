package com.example.inflearnbasic;

import com.example.inflearnbasic.discount.DiscountPolicy;
import com.example.inflearnbasic.discount.FixDiscountPolicy;
import com.example.inflearnbasic.discount.RateDiscountPolicy;
import com.example.inflearnbasic.memeber.MemberService;
import com.example.inflearnbasic.memeber.MemberServiceImpl;
import com.example.inflearnbasic.memeber.MemoryMemberRepository;
import com.example.inflearnbasic.order.OrderService;
import com.example.inflearnbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//생성자통해 객체가 주입되는 생성자 주입..?
//애플리케이션 실제 동작에 필요한 구현객체를 만듦! 생성자 통해 주입(연결)!

//이렇게 바꿀 수 있게되면 이제 ocp도 충족 !! 확장에는 열려있고(갈아끼기 가능), 변경에는 닫혀있다(서비스단에서 직접 뭐 변경안해도 여기서만 바꿔주면 딱 되니까!)

//이제 @Configuration 설정정보 어노테이션과 @Bean 이용해서 편하게 바꿀 수 있음. 그러면 스프링컨테이너에 등록됨

@Configuration
public class AppConfig {  //애플리케이션 실제 동작에 필요한 구현 객체 생성 new new

    //"call 메소드 했으니까 멤퍼레보지토리가 몇번 호출되는지 보자 ..

    //예상대로라면
    //"Call AppConfig.memberService"
    //"Call AppConfig.memberRepository"
    //"Call AppConfig.memberRepository"
    //"Call AppConfig.orderService"
    //"Call AppConfig.memberRepository"

    //실제로는 이렇게 3번만 호출됨! 멤버레포지토리는 싱글톤이기 때문 !
    //"Call AppConfig.memberService"
    //"Call AppConfig.memberRepository"
    //"Call AppConfig.orderService"
    @Bean
    public MemberService memberService(){ //생성한 객체 인스턴스 참조(레퍼런스)를 생성자통해 주입(연결) 해준다
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        //private static이라고 해서 싱글톤 보장이 안됐음! @Configuration과 @Bean의 조합으로 싱글톤을 보장하는 경우는 정적이지 않은 메서드일 때입니다.
        //
        //정적 메서드에 @Bean을 사용하게 되면 싱글톤 보장을 위한 지원을 받지 못합니다.
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
