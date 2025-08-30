// package com.java.security.jwt;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig  {
// 	@Bean
// 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// 		http.csrf(csrf -> csrf.disable())
// 			.authorizeHttpRequests(auth -> auth
// 				.requestMatchers("/member").authenticated()
// 				.requestMatchers("/member/manager").hasAnyRole("MANAGER","ADMIN")
// 				.requestMatchers("/member/admin").hasAnyRole("ADMIN")
// 				.anyRequest().permitAll()
// 			)
// 			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// 			.httpBasic(basic -> basic.disable())
// 			.formLogin(login -> login.disable())
// 			.authorizeHttpRequests(auth -> auth.anyRequest())
// 			.cors(cors -> {}); // 아래에서 등록한 빈을 그냥 쓴다는 말
// 		//Session을 안쓴다는 말임.
// 		return http.build();
//
// 	}
//
// 	@Bean
// 	public CorsFilter corsFilter() {
// 		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// 		CorsConfiguration config = new CorsConfiguration();
// 		config.setAllowCredentials(true);
// 		config.addAllowedHeader("*");
// 		config.addAllowedOrigin("*");
// 		config.addAllowedMethod("*");
// 		source.registerCorsConfiguration("/api/**", config);
// 		return new CorsFilter(source);
// 	}
//
// }
