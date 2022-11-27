package com.spring.demo.dans.rest.web.configuration;


import com.spring.demo.dans.rest.web.response.BaseResponse;

public class CommonResponseHelper {

  private CommonResponseHelper() {
  }

  @SuppressWarnings("unchecked")
  public static <T> BaseResponse<T> constructSuccessResponse(T data) {
    return (BaseResponse.<T>builder()
        .status(200)
        .message("SUCCESS")
        .data(data)
        .build());
  }
}
