package br.com.manageFinanceWallet.Security;

import br.com.manageFinanceWallet.Model.DTO.TokenDTO;
import br.com.manageFinanceWallet.Model.form.LoginForm;
import br.com.manageFinanceWallet.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authentication(@RequestBody @Valid LoginForm login){
        UsernamePasswordAuthenticationToken dataLogin = login.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dataLogin);

            String token = tokenService.createToken(authentication);

            return ResponseEntity.ok( new TokenDTO(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
