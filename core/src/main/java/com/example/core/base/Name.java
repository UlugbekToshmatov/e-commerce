package com.example.core.base;

import com.example.core.exception_handler.ApiException;
import com.example.core.exception_handler.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Name {
    private String uz;
    private String ru;
    private String en;

    public String getByLang(String lang) {
        return switch (lang) {
            case "uz" -> getUz();
            case "ru" -> getRu();
            case "en" -> getEn();
            default -> throw new ApiException(ResponseStatus.INVALID_LANGUAGE);
        };
    }
}
