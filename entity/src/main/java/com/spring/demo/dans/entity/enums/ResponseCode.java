package com.spring.demo.dans.entity.enums;

/**
 * @author Rizky Perdana
 */
public enum ResponseCode {
    DATA_NOT_EXIST("DATA_NOT_EXIST", "No data exist");

    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
