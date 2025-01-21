package com.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name = "users")
@AllArgsConstructor
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_contacts", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Contact> contacts = new HashSet<>();

    //CONSTRUCTOR

    public User() {
    }


    //GETTER AND SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
