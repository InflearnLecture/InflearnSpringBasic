package com.example.inflearnbasic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient/* implements InitializingBean, DisposableBean*/ {

  public String url;

  public NetworkClient() {
    System.out.println("생성자 호출, url = " + url);
//    connect();                      밑에 이니셜라이징빈 상속받아서 에프터프로퍼티~메소드에 넣기. url의존관계 주입 끝나면 커넥트등 이어서 하겠다~
//    call("초기화 연결 메시지");
  }


  public void setUrl(String url) {
    this.url = url;
  }

  //서비스 시작시 호출
  public void connect() {
    System.out.println("connect: " + url);
  }

  public void call(String message) {
    System.out.println("call: " + url + " message = " + message);
  }

  //서비스 종료시 호출
  public void disconnect() {
    System.out.println("close " + url);

  }

//  @Override
//  public void afterPropertiesSet()
//      throws Exception { //이니셜라이징빈 구현메소드, 프로퍼티세팅이 끝나면 호출해주겠다~ 즉 의존관계 주입이 끝나면 호출해주겠다~
//    System.out.println("NetworkClient.afterPropertiesSet");
//    connect();
//    call("초기화 연결 메시지");
//  }
//
//  @Override
//  public void destroy() throws Exception {//디스포저블빈 구현메소드, 빈종료될때 호출되겠지
//    System.out.println("NetworkClient.destroy");
//    disconnect();
//  }

  //  public void init() { //afterPropertiesSet()과 동일한 기능을 구현+오버라이딩안하고 테스트단에서 어노테이션에 추가해주는 것으로 해결(BeanLifeCyclTest)
//    System.out.println("NetworkClient.init");
//
//    connect();
//    call("초기화 연결 메시지");
//  }
//
//
//  public void close() {//destroy()와 동일한 기능을 구현+오버라이딩안하고 테스트단에서 어노테이션에 추가해주는 것으로 해결
//    System.out.println("NetworkClient.close");
//
//    disconnect();
//  }
  @PostConstruct
// 의존관계 주입이 완료 시 스프링 빈 안에 있는 메서드를 호출해주는 기능 // 생성자에서 바로 의존관계 주입 아니라 수정자에서 의존관계 주입해주는 경우는 잘안되니 이렇게 별도로

  public void init() { //afterPropertiesSet()과 동일한 기능을 구현+오버라이딩안하고 테스트단에서 어노테이션에 추가해주는 것으로 해결(BeanLifeCyclTest)
    System.out.println("NetworkClient.init");
    connect();
    call("초기화 연결 메시지");
  }


  @PreDestroy// 죽기 직전에 스프링 빈 안에 있는 메서드를 호출해주는 기능

  public void close() {//destroy()와 동일한 기능을 구현+오버라이딩안하고 테스트단에서 어노테이션에 추가해주는 것으로 해결
    System.out.println("NetworkClient.close");
    disconnect();
  }
}
