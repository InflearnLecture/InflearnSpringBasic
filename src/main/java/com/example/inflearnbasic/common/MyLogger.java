package com.example.inflearnbasic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "request") provider방식
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//, proxyMode = ScopedProxyMode.TARGET_CLASS 이걸 추가해주면 맨처음 방식에서 오류안남! 마치 프로바이더 쓰는 것과 동일한!
//가짜프록시클래스 만들어서 주입!
public class MyLogger {

  private String uuid;
  private String requestURL;

  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }

  public void log(String message) {
    System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
  }

  //빈 생성시점에 초기화 메서드 사용해서 uuid 생성해서 저장 -> 이 빈은 http요청당 하나씩 생성되므로, uuid를 저장해두면
  //다른 http요청과 구분 가
  @PostConstruct //최초 고객 요청시 초기화~
  public void init() {
    uuid = UUID.randomUUID().toString(); // 로또확률급으로 겹침 안겹친다고 보면 됨
    System.out.println("[" + uuid + "] request scope bean create:" + this);
  }

  //빈 소멸 시점에 predestroy로 종료메시지
  @PreDestroy // 고객 나갈 시
  public void close() {
    System.out.println("[" + uuid + "] request scope bean create:" + this);
  }


}
