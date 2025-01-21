package com.demo.service.serviceImpl;


import com.demo.dto.UsersDto;
import com.demo.exception.ResourceNotFoundException;
import com.demo.mapper.UserMapper;
import com.demo.repository.UserRepository;
import com.demo.entity.User;
import com.demo.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UsersDto addUser(UsersDto userDto) {


        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        return userMapper.mapToUsersDto(savedUser);
    }

    @Override
    public UsersDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return userMapper.mapToUsersDto(user);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapToUsersDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto updateUser(UsersDto userDto, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(existingUser);

        return userMapper.mapToUsersDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userRepository.delete(user);
    }

}
