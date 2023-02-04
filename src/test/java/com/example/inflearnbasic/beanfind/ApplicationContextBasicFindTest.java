package com.example.inflearnbasic.beanfind;

import com.example.inflearnbasic.AppConfig;
import com.example.inflearnbasic.memeber.MemberService;
import com.example.inflearnbasic.memeber.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
        //이제 검증은 Assertions로

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        //이제 검증은 Assertions로
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class); //쉬프트엔터로 위에 임포트도 가능함..

    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //이제 검증은 Assertions로
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    //이제 실패 테스트 케이스 작성!


    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //ac.getBean("xxxx", MemberService.class);
        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        //assertThorws는 junit에 있는 Assertions 써야됨!!! 조심!!!
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchMessageException.class,
                //밑에 로직을 실행하면 위에 노서치메시지익셉션 에러가 터져야 한다는 뜻!
                () -> ac.getBean("xxxx", MemberService.class));
    }

}
