package com.example.mailsendingforusers.controller;

import com.example.mailsendingforusers.dto.AppUserDto;
import com.example.mailsendingforusers.dto.GenericResponse;
import com.example.mailsendingforusers.dto.LoginDto;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.mailsendingforusers.dto.EmailSendDto;
import com.example.mailsendingforusers.service.EmailSendService;

import java.io.IOException;

/**
 * @author chandrika
 * user
 * @ProjectName send-mail_using_springboot
 * @since 03-10-2023
 */
@RestController
@RequestMapping("/email")
public class EmailSendController {
      @Autowired
      EmailSendService emailSendService;

      public void sendEmail(@RequestBody EmailSendDto emailSend){
             emailSendService.sendEmail(emailSend);
      }
      @PostMapping("/send")
      public String sendEmailToEmail(@RequestParam(value = "file", required = false)MultipartFile[] file,
                                     @RequestParam(value = "to") String to,
                                     @RequestParam(value = "cc", required = false) String cc,@RequestParam(value = "subject")
                                           String subject,@RequestParam(value = "text") String text) throws MessagingException, IOException {
          return emailSendService.sendEmailToEmail(file, to,cc,subject,text);
      }

    @PostMapping("/send/otp")
    public GenericResponse loginTimeSendOtp(@RequestBody LoginDto dto){
          return emailSendService.sendotptoemail(dto);
      }

    @PostMapping("/save/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public GenericResponse saveUser(@RequestBody AppUserDto dto){
          return emailSendService.save(dto);

      }

    @PostMapping("/verify/otp/for/login")
    public GenericResponse verifyOtpForLogin(@PathVariable String email,@PathVariable String otp){
          return emailSendService.verifyOtpForLogin(email,otp);
      }
}
