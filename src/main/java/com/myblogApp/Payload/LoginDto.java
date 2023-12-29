package com.myblogApp.Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDto {

    private String usernameOrEmail;
    private String password;
}
