package com.example.mailsendingforusers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chandrika
 * user
 * @ProjectName send-mail_using_springboot
 * @since 03-10-2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailSendDto {
    private String id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private String file;
}
