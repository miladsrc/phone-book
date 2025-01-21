package com.demo.dto;



import com.demo.entity.Contact;
import lombok.*;

import java.util.Set;

@Builder
public class UsersDto {

  private String username;
  private String password;
  private String email;
  private Set<Contact> contact;

  //GETTER AND SETTER

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

  public Set<Contact> getContact() {
    return contact;
  }

  public void setContact(Set<Contact> contact) {
    this.contact = contact;
  }

}




