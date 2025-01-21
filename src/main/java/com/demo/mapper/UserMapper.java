package com.demo.mapper;

import com.demo.dto.UsersDto;
import com.demo.entity.User;

import java.util.HashSet;


public class UserMapper {

    public static User mapToUser(UsersDto usersDto) {
        User user = User
                .builder()
                .username(usersDto.getUsername())
                .password(usersDto.getPassword())
                .email(usersDto.getEmail())
                .build();
        return user;
    }

    public static UsersDto mapToUsersDto(User user){
        UsersDto usersDto = UsersDto
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .contact(new HashSet<>(user.getContacts()))
                .build();
        return usersDto;
    }

}