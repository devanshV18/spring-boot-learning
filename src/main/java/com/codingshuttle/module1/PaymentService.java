package com.codingshuttle.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Repsitory
//@Controller
//@Service
//The above 3 annotatiosn or any other stereotype annotation uses @Componenet at its core hence will behave just like Component with some added functionalities but being a component at its core it will  surely make a bean of this class.

//Comment the below component annotation to use configuration method of bean creation of PaymentService obj done inside AppConfig file.
//@Component
public class PaymentService {

    public void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    public void AfterInit(){
        System.out.println("Before Paying");
    }

    @PreDestroy
    public void BeforeDestory(){
        System.out.println("After Payment");
    }
}
