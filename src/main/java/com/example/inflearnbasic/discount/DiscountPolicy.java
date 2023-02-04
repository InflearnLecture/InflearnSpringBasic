package com.example.inflearnbasic.discount;

import com.example.inflearnbasic.memeber.Member;
import org.springframework.stereotype.Component;


public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
