package com.demo.repository;

import com.demo.entity.Contact;
import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.contacts = ?1 where upper(u.contacts) = upper(?2)")
    void updateContact(Contact contacts, @Nullable Contact contacts1);
}
