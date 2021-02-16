package ru.itis.springapp.services;

public interface ConfirmService {
    void confirmUserByCode(String code);
    boolean isUserConfirmedByCode(String code);
}
