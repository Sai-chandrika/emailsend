package com.example.mailsendingforusers.entity;

import com.example.mailsendingforusers.dto.BaseEntity;
import com.example.mailsendingforusers.enums.RoleType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.prefs.BackingStoreException;

/**
 * @author chandrika.g
 * user
 * @ProjectName send-mail_using_springboot
 * @since 21-10-2023
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppUser  extends BaseEntity {
      private String name;
      private String mobileNo;
      private String email;
      private String password;
      private RoleType role;
      private String otp;

}
