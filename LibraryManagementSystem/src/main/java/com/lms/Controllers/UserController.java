package com.lms.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.Exceptions.UserNotFoundException;
import com.lms.Playload.Request.UserRequest;
import com.lms.Playload.Response.UserResponse;
import com.lms.Services.UserService;

@RestController
@RequestMapping("/lms/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> createNewUser(@RequestBody UserRequest request) {
		UserResponse response = userService.createNewUser(request);
		return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<UserResponse> responses = userService.getAllUsers();
		return new ResponseEntity<List<UserResponse>>(responses, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Integer userId) throws UserNotFoundException {
		UserResponse user = userService.getUserById(userId);
		return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
	}
}
