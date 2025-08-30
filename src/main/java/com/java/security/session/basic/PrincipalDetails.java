package com.java.security.session.basic;

// 시큐리티가 /login 경로로 온 요청을 가로채서 처리함

// .formLogin(form -> form
// 	.loginProcessingUrl("/login") // 이 URL로 POST 보내면 자동 처리
// 				.permitAll()
// 			)

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.java.security.session.User;

public class PrincipalDetails implements UserDetails {

	private User user;

	public PrincipalDetails(User user) {
		this.user = user;

	}

	// 생성자에 들어온 유저의 권한을 리턴함
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(user.getRole().getRole()));
	}


	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
}
