package dental_clinic.dental.Config;

import dental_clinic.dental.Service.TokenService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends GenericFilterBean {

    private final TokenService tokenService;
    JWTFilter() {
        this.tokenService = new TokenService();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        try{
            HttpServletRequest request = (HttpServletRequest) req;
            String token = request.getHeader("Authorization");

            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                response.sendError(HttpServletResponse.SC_OK, "success");
                return;
            }
            if (request.getServletPath().contains("/auth/login")
                    ||request.getServletPath().contains("/auth/register") ) {
                response.setStatus(HttpServletResponse.SC_OK);
                filterChain.doFilter(req, res);
            } else {
                if (token == null || !tokenService.isTokenValid(token)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                } else {
                    String userId = new String(tokenService.getUserIdFromToken(token));
                    request.setAttribute("userId", userId);
                    filterChain.doFilter(req, res);
                }
            }
        }
        catch(JwtException ex){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

