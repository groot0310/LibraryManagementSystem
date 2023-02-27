package com.lms.Playload.Request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lms.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

}
