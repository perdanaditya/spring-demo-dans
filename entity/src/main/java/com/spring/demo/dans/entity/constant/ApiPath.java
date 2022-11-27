package com.spring.demo.dans.entity.constant;

/**
 * @author Rizky Perdana
 */
public class ApiPath {

    private static final String BASE_PATH = "/recruitment";
    private static final String JOB = "/job";
    private static final String AUTH = "/token";
    public static final String BY_ID = "/{id}";
    public static final String JOB_ROUTE = BASE_PATH + JOB;
    public static final String AUTH_ROUTE = BASE_PATH + AUTH;
}
