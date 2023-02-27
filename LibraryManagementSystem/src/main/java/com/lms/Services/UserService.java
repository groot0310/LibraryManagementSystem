package com.lms.Services;

import java.util.List;

import com.lms.Exceptions.UserNotFoundException;
import com.lms.Playload.Request.UserRequest;
import com.lms.Playload.Response.UserResponse;


public interface UserService {

	public UserResponse createNewUser(UserRequest request);
	
	public List<UserResponse> getAllUsers();

	public UserResponse getUserById(Integer userId) throws UserNotFoundException;
}
