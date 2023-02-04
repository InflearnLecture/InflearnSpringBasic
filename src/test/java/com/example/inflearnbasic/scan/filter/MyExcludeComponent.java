package com.example.inflearnbasic.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //중요! 필드에붙냐 어디에 붙냐 그런건데 타입이니 클래스에 붙는거??????????
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {  //@interface해서 만들든가~ + @Component 누르면 나오는 타겟등의 어노테이션 복붙

}
