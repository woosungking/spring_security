package com.java.security.session.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/auth")
public class SecurityAuthController {

	@GetMapping("/manager")
	public void managerAuth(){
		System.out.println("Manager!!!");
	}

	@GetMapping("/user")
	public void userAuth(){
		System.out.println("User!!!");
	}

	@GetMapping("/admin")
	public void adminAuth(){
		System.out.println("Admin!!!");
	}

	@GetMapping("/any")
	public void anyAuth(){
		System.out.println("Any!!!");
	}
}

