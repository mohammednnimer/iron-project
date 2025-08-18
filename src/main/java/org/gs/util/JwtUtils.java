package org.gs.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.exception.UnAuthRequestException;

import java.util.*;
import java.util.function.Function;

@ApplicationScoped
public class JwtUtils {
    private String SECRET_KEY = "}9%l#kHC9Ohvl#K3_P2#mQq8l#[lKYِ6";

    public String extractUserCode(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        if (token == null || token.isEmpty()) {
            throw new UnAuthRequestException("Invalid token", "INVALID_TOKEN");
        }
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String userCode, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userCode", userCode);
        claims.put("role", role);
        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(claims.get("userCode").toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48)) // 48 hours
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                .compact();
    }

    public boolean validateToken(String token, String userCode) {
        final String extractedUserCode = extractUserCode(token);
        return (extractedUserCode.equals(userCode) && !isTokenExpired(token));
    }

    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }
}