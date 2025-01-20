package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Add a new user", description = "Creates a new user.")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.addUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by ID", description = "Fetches a user by the provided ID.")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@Parameter(description = "ID of the user to be fetched") @PathVariable("id") Long userId) {
        UserDto savedUser = userService.getUser(userId);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @Operation(summary = "Get all users", description = "Retrieves all users from the system.")
    @ApiResponse(responseCode = "200", description = "Users fetched successfully")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @Operation(summary = "Update user", description = "Updates user details by ID.")
    @ApiResponse(responseCode = "200", description = "User updated")
    @ApiResponse(responseCode = "404", description = "User not found")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto,
            @Parameter(description = "ID of the user to be updated") @PathVariable("id") Long userId) {
        UserDto updatedUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Delete user", description = "Deletes a user by ID.")
    @ApiResponse(responseCode = "200", description = "User deleted")
    @ApiResponse(responseCode = "404", description = "User not found")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "ID of the user to be deleted") @PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
