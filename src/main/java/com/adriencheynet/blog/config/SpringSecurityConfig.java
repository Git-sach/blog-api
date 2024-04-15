package com.adriencheynet.blog.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private String jwtKey = "CE78BC85D87DBDD817F2376E6E33BFD9C8F1C79B9D79BBF0D476EBF91B32D4F";

    /*TODO: Faire de l'autentification que sur les routes concernés
     * Récupérer les infos de l'admin via la BDD
     * Faire un jwt asymétrique
     * Ne pas mettre en dure le jwt
    */


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults())) // filtre qui permet d'extraire le token d'accès des en-têtes HTTP et gérer la validation
        .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
	    SecretKeySpec secretKey = new SecretKeySpec(this.jwtKey.getBytes(), 0, this.jwtKey.getBytes().length,"RSA");
	    return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
    }

    @Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER")
				.build();		
		return new InMemoryUserDetailsManager(user);
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
