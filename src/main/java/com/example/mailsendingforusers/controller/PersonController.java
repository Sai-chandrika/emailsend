//package com.example.mailsendingforusers.controller;
//
//import com.example.mailsendingforusers.dto.LoginDto;
//import com.example.mailsendingforusers.dto.RegisterDto;
//import com.example.mailsendingforusers.service.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author chandrika
// * user
// * @ProjectName mail-sending-for-users
// * @since 28-08-2023
// */
//@RestController
//public class PersonController {
//    @Autowired
//    PersonService personService;
//
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
//        return new ResponseEntity<>(personService.register(registerDto), HttpStatus.OK);
//
//    }
//
//    @PutMapping("verify-account")
//    public  ResponseEntity<String> verifyAccount(@RequestParam String email, @RequestParam String otp){
//        return new ResponseEntity<>(personService.verifyAccount(email,otp), HttpStatus.OK);
//    }
//
//    @PutMapping("/generate-otp")
//    public ResponseEntity<String> regenerateOtp(@RequestParam String email){
//        return new ResponseEntity<>(personService.regenerateOtp(email), HttpStatus.OK);
//
//    }
//
//    @PutMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
//        return new ResponseEntity<>(personService.login(loginDto), HttpStatus.OK);
//
//    }}
