package com.java.security.session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinRequest {
	private String username;

	@Setter
	private String password;

	private Role role;
}
