package com.example.mailsendingforusers.service.impl;

import com.example.mailsendingforusers.dto.*;
import com.example.mailsendingforusers.entity.AppUser;
import com.example.mailsendingforusers.exceptionhandler.IdNotFoundException;
import com.example.mailsendingforusers.exceptionhandler.InvalidDataException;
import com.example.mailsendingforusers.repo.AppUserRepo;
import com.example.mailsendingforusers.security.JwtTokenUtils;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.mailsendingforusers.service.EmailSendService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

/**
 * @author chandrika
 * user
 * @ProjectName send-mail_using_springboot
 * @since 03-10-2023
 */
@Service
public class EmailSendServiceImpl  implements EmailSendService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${otp.length}")
    private int otpLength;
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    BCryptPasswordEncoder bcryptpasswordencoder;
    @Autowired
    JwtTokenUtils jwtTokenUtils;
    @Autowired
    JavaMailSender javaMailSender;




    @Override
    public void sendEmail(EmailSendDto emailSend) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailSend.getTo());
        message.setFrom(emailSend.getFrom());
        message.setSubject(emailSend.getSubject());
        message.setText(emailSend.getText());
        mailSender.send(message);
    }

    @Override
    public void sendEmailWithAttachment(EmailSendDto emailSend) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(emailSend.getTo());
        helper.setFrom(emailSend.getFrom());
        helper.setSubject(emailSend.getSubject());
        helper.setText(emailSend.getText());
        FileSystemResource file = new FileSystemResource(new File("attachment.jpg"));
        helper.addAttachment("attachment.jpg", file);
        mailSender.send(message);
    }

    @Override
    public String sendEmailToEmail(MultipartFile[] file, String to, String cc, String subject, String text) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(message, true);
        mail.setFrom(from);
        mail.setText(text);
        mail.setTo(to);//Message.RecipientType.TO, InternetAddress.parse(recipientEmail)
        mail.setCc(cc);
        mail.setSubject(subject);
        mail.setText(text);
        for (int i = 0; i < file.length; i++) {
            mail.addAttachment(file[i].getOriginalFilename(), new ByteArrayResource(file[i].getBytes()));
        }
        mailSender.send(message);
        return "mail send successfully  :) ";
    }

    public String generateOtp() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    public void sendOTP(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        javaMailSender.send(message);
    }

    @Override
    @SneakyThrows
    public GenericResponse sendotptoemail(LoginDto dto) {
        if (dto.getEmail() == null && dto.getPassword() == null)
            throw new InvalidDataException("email and password are mandatory");
        AppUser optional = appUserRepo.findByEmail(dto.getEmail());
        if (optional == null) throw new IdNotFoundException("user not found");
        if (bcryptpasswordencoder.matches(dto.getPassword(), optional.getPassword())) {
            AppUser appUser=optional;
//            SignInResponce responce = new SignInResponce(optional);
//            responce.setToken(jwtTokenUtils.getToken(optional));
            String otp = generateOtp();
            sendOTP(dto.getEmail(), otp);
            appUser.setOtp(otp);
            appUserRepo.save(appUser);
            return new GenericResponse(HttpStatus.OK.value(), "send otp successfully");
//            return new GenericResponse(HttpStatus.OK.value(), "login successfully", responce);
        } else throw new InvalidDataException("password wrong..........");
    }

    @Override
    public GenericResponse save(AppUserDto dto) {
        AppUser appUser;
        if (dto.getId() != null) {
           return updateUser(dto);
        } else {
            appUser = new AppUser();
            appUser.setName(dto.getName());
            appUser.setEmail(dto.getEmail());
            appUser.setPassword(bcryptpasswordencoder.encode(dto.getPassword()));
            appUser.setRole(dto.getRole());
            appUser.setMobileNo(dto.getMobileNo());
            appUserRepo.save(appUser);
            return new GenericResponse(HttpStatus.OK.value(), "save user successfully", appUser);
        }
    }

    @Override
    @SneakyThrows
    public GenericResponse verifyOtpForLogin(String email, String otp) {
       AppUser optional=appUserRepo.findByEmail(email);
       if(optional==null) throw new IdNotFoundException("user not found");
       String sendOtp=optional.getOtp();
       if(sendOtp==null) throw new InvalidDataException("otp not found for this email");
       if(sendOtp.equals(otp)) {
           SignInResponce responce = new SignInResponce(optional);
           responce.setToken(jwtTokenUtils.getToken(optional));
           return new GenericResponse(HttpStatus.OK.value(), "login successfully", responce);
       }else
        return new GenericResponse(HttpStatus.OK.value(), "otp is not match");
    }

    public GenericResponse updateUser(AppUserDto dto){
        AppUser appUser;
            Optional<AppUser> optional = appUserRepo.findById(dto.getId());
            if (optional.isEmpty()) throw new IdNotFoundException("user is not found");
            appUser = optional.get();
            if(dto.getName()!=null) {
                appUser.setName(dto.getName());
            }
            if(dto.getEmail()!=null) {
                appUser.setEmail(dto.getEmail());
            }
            if(dto.getPassword()!=null) {
                appUser.setPassword(dto.getPassword());
            }
            if(dto.getRole()!=null) {
                appUser.setRole(dto.getRole());
            }
            if(dto.getMobileNo()!=null) {
                appUser.setMobileNo(dto.getMobileNo());
            }
            appUserRepo.save(appUser);
            return new GenericResponse(HttpStatus.OK.value(), "update user successfully", appUser);
        }
}
