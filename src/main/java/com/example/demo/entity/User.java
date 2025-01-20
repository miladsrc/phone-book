package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic(optional = false)
    @Column(unique = true)
    private String username;

    @Basic(optional = false)
    @Column(unique = true)
    private String passwordHash;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_contacts", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Contact> contacts = new HashSet<>();

    private boolean isAccountLocked;
    private String role;

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
