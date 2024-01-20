package com.example.mailsendingforusers.service.impl;

import com.example.mailsendingforusers.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;

/**
 * @author chandrika.g
 * user
 * @ProjectName send-mail_using_springboot
 * @since 20-01-2024
 */
@Service
@EnableScheduling
public class ServerServiceImpl implements ServerService {
    @Value("${server.host}") // Replace with your server's hostname or IP address
    private String serverHost;

    @Value("${server.port}") // Replace with your server's port number
    private int serverPort;

    @Value("${recipient.email}") // Replace with the recipient's email address
    private String recipientEmail;

    @Autowired
    private EmailServerServiceImpl emailService;

    @Scheduled(fixedRate = 60000)
    public void checkServerStatusAndSendEmail() {
        boolean isServerUp = isServerUp(serverHost, serverPort);

        if (isServerUp) {
            System.out.println("Server is UP");
        } else {
            System.out.println("Server is DOWN. Sending email notification...");
            try {
                emailService.sendEmail(recipientEmail, "Server Down Notification",
                        "The server is currently down. Please investigate.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isServerUp(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch ( IOException e) {
            return false;
        }
    }
}
