package com.demo.dto;



import lombok.*;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
  private Long id;
  private String username;
  private String password;
  private String email;
  private Set<ContactDto> contacts;
}





