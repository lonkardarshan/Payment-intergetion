package com.example.demopaymentintergetions.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demopaymentintergetions.payment.EmailRequest;
import com.example.demopaymentintergetions.payment.PaymentRequest;
import com.example.demopaymentintergetions.Otp.OtpService;

import java.util.Random;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
public class PaymentController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/sendOTP")
    public ResponseEntity<String> sendOTP(@RequestBody @Valid EmailRequest emailRequest) throws MessagingException {
        String email = emailRequest.getEmail();
        String otp = otpService.generateOTP();

        // Check for null email
        if (email == null) {
            return ResponseEntity.badRequest().body("Email address cannot be null");
        }

        otpService.sendOtpEmail(email, otp);
        return ResponseEntity.ok("OTP sent to your email address.");
    }
}