package com.marcelo721.payment_system.services;


import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.utils.UserUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    String verifyUrl = "http://localhost:8080/api/v1/users/verify?code=";

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerifyEmail(User user) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "marceloh.sousa@alu.ufc.br";
        String senderName = "Marcelo721";
        String subject = "please verify your registration";
        String content = UserUtil.verificationCodeView();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[NAME]]", user.getName());
        String verifyUrl = this.verifyUrl + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyUrl);
        helper.setText(content, true);

        javaMailSender.send(message);

    }
}
