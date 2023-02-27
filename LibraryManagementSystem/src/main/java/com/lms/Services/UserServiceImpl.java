package com.lms.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lms.Exceptions.UserNotFoundException;
import com.lms.Models.User;
import com.lms.Playload.Request.UserRequest;
import com.lms.Playload.Response.UserResponse;
import com.lms.Repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper mapper;


	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public UserResponse createNewUser(UserRequest request) {
		// TODO Auto-generated method stub
			
		User user = mapper.map(request, User.class);
		
		User savedUser = userRepository.save(user);
		return mapper.map(savedUser, UserResponse.class);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserResponse> responses = userRepository.findAll().stream()
				.map(user -> mapper.map(user, UserResponse.class))
				.collect(Collectors.toList());
		return responses;
	}

	@Override
	public UserResponse getUserById(Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found with userId " + userId));
		return mapper.map(user, UserResponse.class);
	}

}
