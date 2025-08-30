package com.java.security.session.basic;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.security.session.User;
import com.java.security.session.UserRepository;

import lombok.RequiredArgsConstructor;

//규칙이니 암기하도록.
// /login 요청이 오면 IOC되어 있는 놈 중에 loadUserByUsername 이걸 가장 먼저 실행하도록 되어있음.

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		System.out.println(username);
		System.out.println(username);
		User user = userRepository.findByUsername(username);
		if(user !=null){
			return new PrincipalDetails(user);
		}
		return null;
	}
}
