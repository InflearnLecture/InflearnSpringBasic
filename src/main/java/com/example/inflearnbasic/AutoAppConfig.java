package com.example.inflearnbasic;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

//스프링부트.. 스프링부트애플리케이션에서 @SpringBootApplication 눌러보면 컴포넌트스캔까지 다 포함하고 있어서 이렇게 일일히 안해줘도 됨!!!

@ComponentScan(    //@component 내장한 애들자동으로 스캔해서 bean으로 저장..
        basePackages = "com.example.inflearnbasic", //이런식으로 일정 패키지 주소 안에 있는 애들만 등록도 가능!! 그리고 이렇게 해줘야됨!! 안그러면 모든 자바코드 뒤져서 비효율적
        //라이브러리들까지 다 뒤질 수있으니 시작 경로 지정해주기 -> 하지만!!!!! 디폴트값으로 지금 이 autoconfig있는 패키지부터 시작경로 지정됨!!
        //!!!!고로!!!! 지금 이 패키지주소 부터 디폴트값 자동이니 안써줘도되긴함!!
        //!!!!!!!!!!!!!!그래서 config를 제일 상위파일로 만드는건구나!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 하지만 필터기능으로 configuration붙은 어노테이션은 제외하기 appconfig.class같은 애들은 수동으로 빈설정하려고 만든 클래스니


        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //필터..어노테이션타입,컨피규레이션클래스는 제외해라
        //원래 실무에서는 이런거 제외 잘 안하지만 예제코드 살리기 위해!!
        //이제 메모리멤버리파지토리 같은데다가 @Component 붙혀주면 알아서 샥 빈으로 등록될 것임!!! 가서 해보자!
)

public class AutoAppConfig {



}
