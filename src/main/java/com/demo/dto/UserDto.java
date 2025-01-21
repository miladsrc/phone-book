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

//  @JsonProperty("id")
  private Long id;

//  @JsonProperty("username")
  private String username;

//  @JsonProperty("password")
  private String password;

//  @JsonProperty("email")
  private String email;

//  @JsonProperty("contract")
//  private List<ContactDto> contract;
}






