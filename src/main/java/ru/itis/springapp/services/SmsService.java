package ru.itis.springapp.services;

import org.springframework.stereotype.Component;

public interface SmsService {
    void sendSms(String phone, String text);
}
