package com.demo.controller;

import com.demo.dto.UserDto;
import com.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Transactional
    @Operation(summary = "Add a new user", description = "Creates a new user.")
    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.addUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by ID", description = "Fetches a user by the provided ID.")
    @GetMapping(value = "/{id}", headers = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@Parameter(description = "ID of the user to be fetched") @PathVariable("id") Long userId) {
        UserDto savedUser = userService.getUser(userId);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @Operation(summary = "Get all users", description = "Retrieves all users from the system.")
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @Operation(summary = "Update user", description = "Updates user details by ID.")
    @PutMapping( "/update/{id}")
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto,
            @Parameter(description = "ID of the user to be updated") @PathVariable("id") Long userId) {
        UserDto updatedUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Delete user", description = "Deletes a user by ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "ID of the user to be deleted") @PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
