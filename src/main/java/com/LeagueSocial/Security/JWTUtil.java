package com.LeagueSocial.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    //Generation Token for user if authenticated
    public String GenerationToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public boolean ValidToken(String token){
        Claims claims = getClaims(token);
        if(claims != null){
            String username = claims.getSubject();
             Date expirationdDateToken = claims.getExpiration();
             Date nowToken = new Date(System.currentTimeMillis());

             if(username != null && expirationdDateToken != null && nowToken.before(expirationdDateToken)){
                 return true;
             }
        }
        return false;
    }

    public String getUsername(String token){
        Claims claims = getClaims(token);
        if(claims != null){
            return claims.getSubject();
        }
        return null;
    }


    //This method get Claims of the request and opened to check in another method if is valid
    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }


}
