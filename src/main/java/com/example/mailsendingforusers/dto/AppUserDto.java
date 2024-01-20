package com.example.mailsendingforusers.dto;

import com.example.mailsendingforusers.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chandrika.g
 * user
 * @ProjectName send-mail_using_springboot
 * @since 21-10-2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUserDto {
    private String id;
    private String name;
    private String mobileNo;
    private String email;
    private String password;
    private RoleType role;
}
