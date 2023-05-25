package com.crud.CrudDemo.email;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping("/send-simple-mail")
    public ResponseEntity<String> sendSimpleMail(@RequestBody EmailRequestDto emailRequestDto){

        String message = emailService.sendSimpleMail(emailRequestDto);

        return ResponseEntity.ok(message);
    }
}
