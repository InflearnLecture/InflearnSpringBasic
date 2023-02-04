package com.example.inflearnbasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest() {

    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
        LifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);
    ac.close(); // 여기선 이게 필요 !

  }

  @Configuration
  static class LifeCycleConfig {

    @Bean/*(initMethod = "init", destroyMethod = "close") 네트워크클라이언트 클래스에서 설명 읽어보기*/
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("http://hello-spring.dev");
      return networkClient;
    }

  }


}
