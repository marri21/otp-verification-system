package com.otp.service;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailService {

    public static void sendOtp(String toEmail, String otp) {

        final String fromEmail = "marriprashanthyadav21@gmail.com";
        final String password = "xnpwoguwtkjuudzt";

        // Step 1: SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Step 2: Create mail session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Step 3: Create message
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject("OTP Verification");
            message.setText("Your OTP is: " + otp);

            // Step 4: Send mail
            Transport.send(message);

            System.out.println("OTP Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}