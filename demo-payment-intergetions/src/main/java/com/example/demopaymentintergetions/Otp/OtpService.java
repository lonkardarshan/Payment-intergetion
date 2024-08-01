package com.example.demopaymentintergetions.Otp;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class OtpService {

    private final JavaMailSender emailSender;

    public OtpService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendOtpEmail(String email, String otp) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Check for null or empty email
        if (email == null || email.isEmpty()) {
            email = "darshanlonkar2023@gmail.com"; // Set a default email address
        }

        helper.setTo(email);
        helper.setSubject("Your OTP");
        helper.setText("Your OTP is: " + otp);

        emailSender.send(message);
    
}

    public String generateOTP() {
        Random random = new Random();
        int otp = random.nextInt(999999);
        return String.format("%06d", otp);
    }
}
