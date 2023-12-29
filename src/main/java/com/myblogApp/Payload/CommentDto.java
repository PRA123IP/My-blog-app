package com.myblogApp.Payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private long id;
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "comment email should  have at least valid char ")
    private String email;
    private String body;
}
