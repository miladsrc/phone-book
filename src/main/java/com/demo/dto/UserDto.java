package com.demo.dto;



import lombok.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String username;
  private String password;
  private String email;
  private List<ContactDto> contract;
}






