package com.adriencheynet.blog.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

/*Service qui permet de génréer un token JWT */
@Service
public class JWTService {

    private JwtEncoder jwtEncodre;

    public JWTService(JwtEncoder jwtEncodre) {
        this.jwtEncodre = jwtEncodre;
    }

    // Authentication est un objet mise a disposition par Spring Security permetant d'accéder aux informations de l'utilisateur autentifié
    // Cette methode permet de spécifier tous les élement pour configurer un token
    public String generateToken(Authentication authentication) {
        Instant now  = Instant.now(); // Durée dans le temps du tocken
        JwtClaimsSet claims = JwtClaimsSet
        .builder()
        .issuer("self")
        .issuedAt(now)
        .expiresAt(now.plus(1, ChronoUnit.DAYS))
        .subject(authentication.getName())
        .build();

        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return this.jwtEncodre.encode(jwtEncoderParameters).getTokenValue();
    }
}
