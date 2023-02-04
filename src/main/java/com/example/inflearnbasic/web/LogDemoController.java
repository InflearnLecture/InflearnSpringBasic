package com.example.inflearnbasic.web;

import com.example.inflearnbasic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

//  private final MyLogger myLogger; //얘 생존범위가 고객리퀘스트들어오고 나갈때까진데 스프링띄우는 단계에서는 리퀘스트없으니! 오류 뜸!
  //생존범위가 아닌데 의존관계주입할테니 내놓으라고 하니까 실행이 안되는 것~
  //ObjectProvider 덕분에 이제 ObjectProvider.getObject()를 호출하는 시점까지 request scope의 빈생성을 지연해주는 것..

  //  private final ObjectProvider<MyLogger> myLoggerProvider;
  private final MyLogger myLogger;
  private final LogDemoService logDemoService;


  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) throws InterruptedException {
    String requestURL = request.getRequestURL().toString();
//    MyLogger myLogger = myLoggerProvider.getObject();
    System.out.println(
        "myLogger = "
            + myLogger.getClass()); //프록시일 때 확인. 내가 만든 마이로거가 아니라 스프링이 만들어둔듯한 애가 나옴(로컬호스트8080 들어가서 뭐하면 맨위..)
    //프록시가 프로바이더마냥 동작하는 것
    myLogger.setRequestURL(requestURL);

    myLogger.log("controller test");
//    Thread.sleep(1000); // 이렇게 쓰레드 멈추고 로컬호스트8080가서 f5연타로 실험해봐도 uuid로 동일개체판별 유효함
    logDemoService.logic("testID");

    return "OK";
  }

}
