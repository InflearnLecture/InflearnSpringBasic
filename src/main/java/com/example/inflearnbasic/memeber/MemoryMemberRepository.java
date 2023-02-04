package com.example.inflearnbasic.memeber;

import com.example.inflearnbasic.memeber.Member;
import com.example.inflearnbasic.memeber.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // static을 활용 단 1개의 맵만 되는 구조로 이용하는구나..

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // 멤버에도 아이디 있어서 낭비다는 생각이 들 수 있지만 아님. 아이디 기준으로 멤버가 가진 칼럼들 다 볼 수 있는거니

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
