package com.example.inflearnbasic.order;

import com.example.inflearnbasic.annotation.MainDiscountPolicy;
import com.example.inflearnbasic.discount.DiscountPolicy;
import com.example.inflearnbasic.discount.FixDiscountPolicy;
import com.example.inflearnbasic.memeber.Member;
import com.example.inflearnbasic.memeber.MemberRepository;
import com.example.inflearnbasic.memeber.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
//
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//
    private final MemberRepository memberRepository; //이제 얘는 인터페이스(추상화)에만 의존 가능. 배우(어떤 구현체)쓸지는 위에서 알아서 해주니까
                                                    //본연의 기능에 충실해지는 것!!! 위에처럼 new FixDiscountPolicy();해서 직접 배우 캐스팅하는게 아니니까
                                                        //이게 바로 dip(Dependency Inversion Principle의 약어)로 구현체에 의존하지 말고,
                                                    // 역할(인터페이스)에 의존해야 한다는 원칙입니다.
    private final DiscountPolicy discountPolicy;



    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {  //final 있으면 생성자에 무조건 할당해줘야함
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; //이제 얘는 어떤 discountpolicy가 들어올지 모름 config에서 골라주는 걸로 들어오겠지? 아닌가
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
