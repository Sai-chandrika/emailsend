package com.example.mailsendingforusers.service;
//
//import com.example.mailsendingforusers.entity.EmailUtil;
//import com.example.mailsendingforusers.entity.OtpUtil;
//import com.example.mailsendingforusers.entity.Person;
import com.example.mailsendingforusers.dto.LoginDto;
import com.example.mailsendingforusers.dto.RegisterDto;
//import com.example.mailsendingforusers.repo.PersonRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author chandrika
 * user
 * @ProjectName mail-sending-for-users
 * @since 28-08-2023
 */
@Service
public class PersonService {
//  @Autowired
//    OtpUtil otpUtil;
//  @Autowired
//    EmailUtil emailUtil;
//  @Autowired
//    PersonRepo personRepo;


//    public String register(RegisterDto registerDto){
//     String otp=otpUtil.generateOtp();
//     try{
//         emailUtil.sendOtpEmail(registerDto.getEmail(), otp);
//     } catch (MessagingException e) {
//         throw new RuntimeException("unable to send otp please try again");
//     }
//     Person user=new Person();
//     user.setName(registerDto.getName());
//     user.setEmail(registerDto.getEmail());
//     user.setPassWord(registerDto.getPassword());
//     user.setOtp(otp);
//     user.setOtpGeneratedTime(LocalDateTime.now());
//     personRepo.save(user);
//     return "User Registration Successfully";
// }

//    public String verifyAccount(String email, String otp) {
//   Person person=  personRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not found with this email: " + email));
//
//     if(person.getOtp().equals(otp) && Duration.between(person.getOtpGeneratedTime(), LocalDateTime.now()).getSeconds() < (60)){
//         person.setActive(true);
//         return "OTP verified you can login";
//     }
//     return "Please regenerate otp and try again";
//    }

//    public String regenerateOtp( String email) {
//     Person person=personRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not found this email: " + email));
//             String otp=otpUtil.generateOtp();
//        try{
//            emailUtil.sendOtpEmail(email, otp);
//        } catch (MessagingException e) {
//            throw new RuntimeException("unable to send otp please try again");
//        }
//
//        person.setOtp(otp);
//        person.setOtpGeneratedTime(LocalDateTime.now());
//        personRepo.save(person);
//      return "Email sent ... please verify account within 1 minute";
//    }
//
//    public String login(LoginDto loginDto){
//        Person person=personRepo.findByEmail(loginDto.getEmail()).orElseThrow(()->new RuntimeException("user not found this email: " + loginDto.getEmail()));
//    if(!loginDto.getPassword().equals(person.getPassWord())){
//        return "password is incorrect";
//    }else if(!person.isActive()){
//        return "your account is not verified";
//    }
//return "Login successfully";
//    }
}
