package com.java.security.session;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/security/role")
@RequiredArgsConstructor
public class JoinController {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	@PostMapping("/join")
	public void join(@RequestBody JoinRequest request){
		String password = request.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		request.setPassword(encodedPassword);
		User user = new User(request);
		userRepository.save(user);
	}

	@PostMapping("/login")
	public void login(){
		System.out.println("dddd");
	}
}
