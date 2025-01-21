package com.demo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;
}

