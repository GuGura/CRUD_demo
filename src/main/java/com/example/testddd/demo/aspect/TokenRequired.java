package com.example.testddd.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //언제 적용할거냐 묻는 어노테이션 (우린 runtime으로)
@Target(ElementType.METHOD) //타입은 메소드로
public @interface TokenRequired { //어노테이션 만드는법 인터페이스에 @추가

}
