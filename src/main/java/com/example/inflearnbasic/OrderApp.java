package com.example.inflearnbasic;

import com.example.inflearnbasic.memeber.Grade;
import com.example.inflearnbasic.memeber.Member;
import com.example.inflearnbasic.memeber.MemberService;
import com.example.inflearnbasic.memeber.MemberServiceImpl;
import com.example.inflearnbasic.order.Order;
import com.example.inflearnbasic.order.OrderService;
import com.example.inflearnbasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
//이제 스프링 쓸거니 위에 주석처리 하고
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);

        System.out.println("order = " + order);

        System.out.println("order = " + order.calculatePrice());

    }

}
