package com.example.inflearnbasic.discount;

import com.example.inflearnbasic.annotation.MainDiscountPolicy;
import com.example.inflearnbasic.memeber.Grade;
import com.example.inflearnbasic.memeber.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Qualifier("mainDiscountPolicy")//이렇게하면 오타나도 바로바로 컴파일에러뜸! @Qualifier("오타") 보다 더 정확
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
