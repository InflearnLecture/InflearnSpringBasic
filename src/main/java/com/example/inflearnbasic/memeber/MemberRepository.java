package com.example.inflearnbasic.memeber;

public interface MemberRepository {   //추후 여러개의 메모리레포지토리 갈아낄 수 있으니 인터페이스로 만들고 밑에처럼 멤버메모리레포 만드는 것

    void save(Member member);

    Member findById(Long memberId);

}
