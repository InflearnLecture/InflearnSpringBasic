package com.example.inflearnbasic.web;

import com.example.inflearnbasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  //  private final MyLogger myLogger; 이것도 provider! common의 MyLogger클래스처럼
//  private final ObjectProvider<MyLogger> myLoggerProvider;
  private final MyLogger myLogger;

  public void logic(String id) {
//    MyLogger myLogger = myLoggerProvider.getObject();
    myLogger.log("service id = " + id);
  }

}
