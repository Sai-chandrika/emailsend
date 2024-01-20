package com.example.mailsendingforusers.repo;

import com.example.mailsendingforusers.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author chandrika.g
 * user
 * @ProjectName send-mail_using_springboot
 * @since 21-10-2023
 */
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {
AppUser findByEmail(String email);

    AppUser findByName(String userName);

    AppUser findByMobileNo(String userName);
}
