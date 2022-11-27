package com.spring.demo.dans.libraries.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Rizky Perdana
 */
public class JWTHelper {
    private static final long JWT_TOKEN_VALIDITY = 5*60*60;

    private JWTHelper() {
    }

    public static String generateToken(String username, String password) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username.concat(password));
    }

    private static String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(
                SignatureAlgorithm.HS512, "dans").compact();
    }

    private static Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("dans").parseClaimsJws(token).getBody();
    }

    public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

}
