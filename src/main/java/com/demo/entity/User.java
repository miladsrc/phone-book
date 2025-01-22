package com.demo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    String username;

    @Column(name = "PASSWORD", nullable = false)
    String password;

    @Column(name = "EMAIL", nullable = false, unique = true)
    String email;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Contact> contacts = new HashSet<>();

}
