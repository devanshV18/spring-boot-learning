package com.codingshuttle.module1;

import com.codingshuttle.module1.impl.EmailNotificationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

    //field depemdemcy injection -> not very preferred as it is s;lightly mutable.
    //@Autowired
//    final NotificationService notificationServiceObj;


    //conmstructor DI.
//    public Module1Application(NotificationService notificationServiceobj) {
//            //the below line checks for @Component / @Priomary annotations on the implementations for NotificationService, whatever is available or takes precedence is set insidet the notificatipnServcieObject field of this class.
//        this.notificationServiceObj = notificationServiceobj; //constructor DI - preferred. (remove or comment autowired)
//    }


    //Getting instance of all beans - suppose we have a use case where we want to use beans of all types to send multiple notifs.
    @Autowired
    Map<String, NotificationService> notificationservcieMap = new HashMap<>();


    public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        //What does the two lines of code below do?

        //NotificationService notificationServiceObj = new EmailNotificationService();
        //notificationServiceObj.send("Hello");

        // creates an obj of type NotificationService(an interface) using any of the two implementations either Email or Sms, but this creates a strong dependency of our main class (Module1Application class) with the type of NotificationService we are using.

        //Problem ->  when we want to change the type of NotificationService, we need to come here and make changes in the code, but we want to use the NotificationService dynamically. This is the problem which is solved by the Dependency Injection.

        //uses the available bean out of the Email and Sms Service
        //notificationServiceObj.send("hello");

        //demonstrating the use of all beans available in the map -> Comment Qualifier annotations only then it will work (for 2 beans else the qualifier will create the bean for the type specified in application.properties.)
        for(var notificationService: notificationservcieMap.entrySet()){
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("hello");
        }
    }

    //WHY CONSTRUCTOR DI -> we make the field final and then it can only be instantiated using a constructor and cant be updated or changed in the code.

}
