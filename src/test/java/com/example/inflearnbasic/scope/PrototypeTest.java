package com.example.inflearnbasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

  @Test
  void prototypeBeanFind() {

    AnnotationConfigApplicationContext ac;
    ac = new AnnotationConfigApplicationContext(   //이게 컴포넌트스캔역할해준다고 보면 됨 이 안에 넣었으니 자동으로 빈 등록
        PrototypeBean.class);
    System.out.println("find bean1");
    PrototypeBean bean = ac.getBean(PrototypeBean.class);
    System.out.println("find bean2");
    PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

    System.out.println("bean = " + bean);
    System.out.println("bean2 = " + bean2);
//    Assertions.assertThat(bean).isSameAs(bean2);
    Assertions.assertThat(bean).isNotSameAs(bean2); //앞의 싱글톤과 달리 프로토타입빈은 스프링컨테이너에 요청할때마다 아예 새로 생성됨.

    ac.close(); //호출 안됨! why? 프로토타입빈은 만들기만하고 그 이후는 관리안하기 때문.. 종료메소드가 호출되지 않음
    //만약 종료하고 싶으면
    bean.destroy(); //이런식으로 일일히 수동으로 직접 호출해서 종료해줘야됨
    bean2.destroy();
  }

  @Scope("prototype")
  static class PrototypeBean {

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }

}

