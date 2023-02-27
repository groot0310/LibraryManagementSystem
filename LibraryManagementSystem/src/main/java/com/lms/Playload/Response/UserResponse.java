package com.lms.Playload.Response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lms.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {


	private Integer userId;
	private String username;
	@Enumerated(EnumType.STRING)
	private Role role;

}
