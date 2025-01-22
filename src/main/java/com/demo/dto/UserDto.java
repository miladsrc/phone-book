package com.demo.dto;



import lombok.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String username;
  private String password;
  private String email;
  private Set<ContactDto> contact;
}






