package com.example.inflearnbasic.OrderServiceTest;

import com.example.inflearnbasic.AppConfig;
import com.example.inflearnbasic.memeber.Grade;
import com.example.inflearnbasic.memeber.Member;
import com.example.inflearnbasic.memeber.MemberService;
import com.example.inflearnbasic.memeber.MemberServiceImpl;
import com.example.inflearnbasic.order.Order;
import com.example.inflearnbasic.order.OrderService;
import com.example.inflearnbasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }




    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


}
