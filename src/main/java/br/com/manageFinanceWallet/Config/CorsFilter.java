package br.com.manageFinanceWallet.Config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {

    private String originPermitida = "http://localhost:8000"; //TODO: COnfigurar para diferentes ambientes

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest  request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Origin" , originPermitida);
        response.setHeader("Access-Control-Allow-Credentials" , "true");

        if("OPTIONS".equals(request.getMethod())
                && originPermitida.equals(request.getHeader("Origin"))){
            response.setHeader("Access-Control-Allow-Methods" , "POST, GET, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers" , "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Max-Age" , "3600");

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req,resp);
        }

    }
}
