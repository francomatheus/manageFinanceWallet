package br.com.manageFinanceWallet.token.service;

import br.com.manageFinanceWallet.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private final long timeOfExpiration = 86400000L;

    @Value("${jwt.secret}")
    private String secret;


    public String createToken(Authentication authentication) {
        User loginIn = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expiration = new Date(today.getTime() + timeOfExpiration);

        return Jwts.builder()
                .setIssuer("API manager finance wallet") //Dono
                .setSubject(loginIn.getCodigo().toString()) //Quem está gerando o token (Usuario)
                .setIssuedAt(today) //Passar a data de criação
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256 , secret )
                .compact();

    }

    public boolean isTokenvalid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getCodeUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
