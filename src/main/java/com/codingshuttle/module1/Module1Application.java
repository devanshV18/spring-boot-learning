package com.codingshuttle.module1;

import com.codingshuttle.module1.impl.EmailNotificationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

    @Autowired
    NotificationService notificationServiceObj;

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //What does the two lines of coce below do?
        // creates an obj of type NotificationService(an interface) using any of the two implementations either Email or Sms, but this creates a strong dependency of our main class (Module1Application class) with the type of NotificationService we are using.

        //Problem ->  when we want to change the type of NotificationService, we need to come here and make changes in the code, but we want to use the NotificationService dynamically. This is the problem which is solved by the Dependency Injection.

//        NotificationService notificationServiceObj = new EmailNotificationService();
//        notificationServiceObj.send("Hello");

        notificationServiceObj.send("hello"); //uses the available bean out of the Email and Sms Service
    }


}
