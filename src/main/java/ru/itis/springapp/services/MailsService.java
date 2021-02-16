package ru.itis.springapp.services;

public interface MailsService {
    void sendEmailForConfirm(String email, String code);
}
