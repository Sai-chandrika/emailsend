//package com.example.mailsendingforusers.entity;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
///**
// * @author chandrika
// * user
// * @ProjectName mail-sending-for-users
// * @since 28-08-2023
// */
//@Configuration
//public class EmailConfiguration {
//    @Value("${spring.mail.host}")
//    private String mailHost;
//    @Value("${spring.mail.port}")
//    private String mailPort;
//    @Value("${spring.mail.username}")
//    private String userName;
//    @Value("${spring.mail.password}")
//    private String password;
//
//    public JavaMailSender getJavaMailSender(){
//        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
//        javaMailSender.setHost(mailHost);
//        javaMailSender.setPort(Integer.parseInt(mailPort));
//        javaMailSender.setUsername(userName);
//        javaMailSender.setPassword(password);
//
//
//        Properties properties=javaMailSender.getJavaMailProperties();
//        properties.put("mail.smtp.starttls.enable", "true");
//        return javaMailSender;
//    }
//}
