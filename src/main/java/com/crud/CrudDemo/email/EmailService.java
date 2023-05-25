package com.crud.CrudDemo.email;

public interface EmailService {

    String sendSimpleMail(EmailRequestDto emailWithAttachmentDto);

    String sendMailWithAttachments(EmailRequestDto emailWithAttachmentDto);
}
