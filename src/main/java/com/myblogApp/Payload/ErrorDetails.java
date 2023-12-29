package com.myblogApp.Payload;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetails {


    private Date timestamp;
    private String message;
    private String details;


}
