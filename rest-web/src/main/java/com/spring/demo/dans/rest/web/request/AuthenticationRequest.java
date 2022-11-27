package com.spring.demo.dans.rest.web.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class AuthenticationRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
