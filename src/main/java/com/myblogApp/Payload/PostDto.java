package com.myblogApp.Payload;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PostDto {
    private long id;
    @NotNull
    @Size(min=2,message = "post title should  have at least 2 char ")
    private String title;
    @NotNull
    @Size(min=10,message = "post description should  have at least 10 char ")
    private String description;
    private String content;


}
