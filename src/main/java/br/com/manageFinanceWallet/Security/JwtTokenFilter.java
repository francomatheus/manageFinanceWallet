package br.com.manageFinanceWallet.Security;

import br.com.manageFinanceWallet.Entity.User;
import br.com.manageFinanceWallet.Repository.UserRepository;
import br.com.manageFinanceWallet.token.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    public JwtTokenFilter( TokenService tokenService, UserRepository userRepository){
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Pegando o token
        String token = getTokenFromRequest(request);

        //Verificando se token é valido
        boolean valid = tokenService.isTokenvalid(token);

        //Considere que o cliente esta mandando a requisição está autenticado
        if (valid){
            authenticClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticClient(String token) {
        Long codigoUser = tokenService.getCodeUser(token);
        User user = userRepository.findById(codigoUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities() );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String token =  request.getHeader("Authorization");
        if( token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
