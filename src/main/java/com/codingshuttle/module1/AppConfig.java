package com.codingshuttle.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //The below bean creation is done using @Bean annotation where we need to define a bean constructor method that actually has the logic of how our bean should be created by spring -> slighlty more control in our hand.
    //Internally bean creation, management and deletion is handled by spring only but we specify hoe bean should be created in this type of bean creation using configuration and bean annotation.

    @Bean
    PaymentService paymentServiceBeanCreation(){
        //some extra logic as per our requirement can go here to create our bean with some specific logics etc
        return new PaymentService();
    }
}
