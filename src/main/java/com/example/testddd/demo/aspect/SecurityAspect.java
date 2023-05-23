package com.example.testddd.demo.aspect;

import com.example.testddd.demo.service.SecurityService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    SecurityService securityService;

        @Before("@annotation(tokenRequired)")
        public void authenticateWithToken(TokenRequired tokenRequired){
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();

            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token)){ //비어있는지 확인
            throw new IllegalArgumentException("token is empty");
        }

        if(securityService.getClaims(token) == null || securityService.getSubject(token) == null){
            throw new IllegalArgumentException("token error!! claims or subject are null!!");
        }

        // subject 기반으로 자체인증로직~~~

    }
}
