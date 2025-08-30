package com.java.security.session;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private Role role;

	public User(String userid, String password, Role role) {
		this.username = userid;
		this.password = password;
		this.role = role == null ? Role.ROLE_USER : role;
	}

	public User(JoinRequest request){
		this.username = request.getUsername();;
		this.password = request.getPassword();
		this.role = role == null ?  request.getRole(): Role.ROLE_USER;
	}
}
