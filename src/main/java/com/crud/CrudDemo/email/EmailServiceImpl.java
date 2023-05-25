package com.crud.CrudDemo.email;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public String sendSimpleMail(EmailRequestDto emailRequestDto) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(emailRequestDto.getFrom());
        simpleMailMessage.setTo(emailRequestDto.getTo());
        simpleMailMessage.setSubject(emailRequestDto.getSubject());
        simpleMailMessage.setText(emailRequestDto.getText());

        try{
            emailSender.send(simpleMailMessage);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "email sent successfully";
    }

    @Override
    public String sendMailWithAttachments(EmailRequestDto emailWithAttachmentDto) {
        return null;
    }
}
