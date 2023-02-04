package com.example.inflearnbasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;
class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadA : B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 이러면 A사용자가 서비스1에 10000주문 했지만 조회 전에 B사용자가 서비스2에 20000주문했음에도 서비스1주문했음에도 20000으로 찍힘
                                                // 같은 객체기 때문..
                                                //따라서 스프링빈은 항상 stateless(무상태)로 설계해야됨 ..ex)필드값이 아니라 지역변수 활용
                                                //StatefulService에서 order에다가 void에서  int order로 바꾸고 바로 return price하고
        // 위에 int price = statefulService1.order(....) 이런식으로 바로 가격반환
    }
    static class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}