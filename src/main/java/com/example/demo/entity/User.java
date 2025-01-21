package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "user-name")
    String name;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, unique = true)
    String email;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_contacts", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Contact> contacts = new HashSet<>();

}
