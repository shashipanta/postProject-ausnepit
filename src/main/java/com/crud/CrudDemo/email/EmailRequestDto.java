package com.crud.CrudDemo.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {

    private String to;
    private String from;
    private String subject;
    private String name;
    private String text;


    // optional field : only for mail with attachments
    private String attachmentPath;
}
