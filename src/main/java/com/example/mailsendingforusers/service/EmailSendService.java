package com.example.mailsendingforusers.service;

import com.example.mailsendingforusers.dto.AppUserDto;
import com.example.mailsendingforusers.dto.GenericResponse;
import com.example.mailsendingforusers.dto.LoginDto;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;
import com.example.mailsendingforusers.dto.EmailSendDto;

import java.io.IOException;

/**
 * @author chandrika
 * user
 * @ProjectName send-mail_using_springboot
 * @since 03-10-2023
 */
public interface EmailSendService {



    void sendEmail(EmailSendDto emailSend);
    void sendEmailWithAttachment(EmailSendDto emailSend) throws MessagingException;

    String sendEmailToEmail(MultipartFile[] file, String to, String cc, String subject, String text) throws MessagingException, IOException;
   GenericResponse sendotptoemail(LoginDto dto);

    GenericResponse save(AppUserDto dto);

    GenericResponse verifyOtpForLogin(String email, String otp);
}
