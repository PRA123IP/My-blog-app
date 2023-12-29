package com.myblogApp.Dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SignUPDto {

    private String name;
    private String username;
    private String email;
    private String password;
}
