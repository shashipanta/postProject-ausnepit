package com.crud.CrudDemo.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

    private String from;
    private String to;
    private String body;
    private String subject;

}
