package com.example.mailsendingforusers.dto;

import com.example.mailsendingforusers.entity.AppUser;
import com.example.mailsendingforusers.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chandrika.g
 * user
 * @ProjectName ticket_bug_system
 * @since 07-10-2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignInResponce {
    private String id;
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    private RoleType role;
    private String token;

    public SignInResponce(AppUser user) {
        this.id=user.getId();
        this.name = user.getName();
        this.email=user.getEmail();
        this.role=user.getRole();
        this.mobileNo=user.getMobileNo();
    }
}
