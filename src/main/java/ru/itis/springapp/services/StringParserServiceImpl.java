package ru.itis.springapp.services;

import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
public class StringParserServiceImpl implements StringParserService {
    @Override
    public String getValueOfParamFromString(String stringWithData, String nameOfParam) {
        if (stringWithData != null) {
            String[] data = stringWithData.split("&");
            for (String str : data) {
                if (str.toLowerCase().startsWith(nameOfParam.toLowerCase())) {
                    String[] strArr = str.split("=");
                    if (strArr.length < 2) {
                        return null;
                    } else {
                        return strArr[1];
                    }
                }
            }
        }
        return null;
    }
}
