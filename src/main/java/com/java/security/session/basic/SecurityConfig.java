package com.java.security.session.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Spring Security 필터 체인을 활성화 (WebSecurityConfigurerAdapter 대신 사용)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// 🔒 CSRF 보호 기능 비활성화 (REST API 서버에서는 보통 사용하지 않음)
			.csrf(csrf -> csrf.disable())

			// ✅ URL별 권한 규칙 정의
			.authorizeHttpRequests(auth -> auth
				// "/user/**" 경로는 인증된 사용자(로그인한 유저)만 접근 가능
				.requestMatchers("/security/auth/user/**").authenticated()
				// "/manager/**" 경로는 ADMIN 또는 MANAGER 권한을 가진 유저만 접근 가능
				.requestMatchers("/security/auth/manager/**").hasAnyRole("ADMIN", "MANAGER")
				// "/admin/**" 경로는 ADMIN 권한이 있어야만 접근 가능
				.requestMatchers("/security/auth/admin/**").hasRole("ADMIN")
				// 그 외의 모든 요청은 인증/인가 없이 접근 허용
				.anyRequest().permitAll()
			)
			// 🔑 기본 로그인 폼 활성화 (/login 경로를 자동 제공)
			// - 세션 기반 인증이 기본 동작
			// - 로그인 실패/성공 핸들러도 기본 제공 (커스터마이징 가능)
			.formLogin(form -> form
				.loginProcessingUrl("/security/role/login") // 이 URL로 POST 보내면 자동 처리
				.permitAll()
			)
			.sessionManagement(session -> session
				.maximumSessions(1) // 세션 1개만 허용
			);

		// 최종적으로 SecurityFilterChain 빈 생성
		return http.build();
	}
}
