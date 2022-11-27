package com.spring.demo.dans.rest.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rizky Perdana
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateResponse {

    private String token;
}
