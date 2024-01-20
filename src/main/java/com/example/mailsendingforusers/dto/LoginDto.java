package com.example.mailsendingforusers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chandrika
 * user
 * @ProjectName mail-sending-for-users
 * @since 29-08-2023
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String contactNo;
    private String password;
}
