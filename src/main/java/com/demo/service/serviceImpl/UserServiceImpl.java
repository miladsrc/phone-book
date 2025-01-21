package com.demo.service.serviceImpl;

import com.demo.dto.UsersDto;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsersDto addUser(UsersDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UsersDto.class);
    }

    @Override
    public UsersDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return modelMapper.map(user, UsersDto.class);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UsersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto updateUser(UsersDto userDto, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(existingUser);
        return modelMapper.map(savedUser, UsersDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }

}
