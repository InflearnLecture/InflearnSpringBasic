package com.example.inflearnbasic.singleton;

import java.security.Signature;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { //생성자를 private로 막아야 싱글톤 완성!! 외부에서 new 키워드로 객체 생성 막음 !
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
