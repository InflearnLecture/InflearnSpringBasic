package com.example.inflearnbasic.memeber;

public interface MemberService {

    public void join(Member member);

    Member findMember(Long memberId);
}
