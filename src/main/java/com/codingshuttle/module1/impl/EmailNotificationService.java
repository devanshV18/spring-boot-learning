package com.codingshuttle.module1.impl;

import com.codingshuttle.module1.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email Sending... " + message);
    }
}
