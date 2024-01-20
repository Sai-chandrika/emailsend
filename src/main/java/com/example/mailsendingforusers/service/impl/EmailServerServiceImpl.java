package com.example.mailsendingforusers.service.impl;

import com.example.mailsendingforusers.service.EmailServerService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author chandrika.g
 * user
 * @ProjectName send-mail_using_springboot
 * @since 20-01-2024
 */
@Service
public class EmailServerServiceImpl implements EmailServerService {

      private final JavaMailSender mailSender;
      @Value("${spring.mail.username}")
      private final String from;

      public EmailServerServiceImpl(JavaMailSender mailSender,  String from) {
            this.mailSender = mailSender;
            this.from = from;
      }

      public void sendEmail(String to, String subject, String body) throws MessagingException {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(message, true);
            mail.setFrom(from);
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            mailSender.send(message);
            System.out.println("Email sent successfully.");
      }
}
