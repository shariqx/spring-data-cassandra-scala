package com.shariqx.springboot.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.shariqx.springboot.constants.SecurityConstants.*;

@CrossOrigin
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        System.out.println(req.getMethod());
        if (req.getMethod().equals("OPTIONS")) {
            res.setStatus(200);
            res.addHeader("Access-Control-Allow-Origin", "*");
            return;
        }

        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            res.setStatus(403);
            //chain.doFilter(req, res);
            return;
        }
        // parse the token.
        String token = req.getHeader(HEADER_STRING);
        DefaultClaims claim = null;
        try {
            claim = (DefaultClaims) Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        }
        catch (ExpiredJwtException e) {
            res.setStatus(401);
            return;
        }
        catch(SignatureException se) {
            res.setStatus(401);
            res.getWriter().write("Invalid Token!");
            chain.doFilter(req,res);
            return;
        }
        String user = claim.getSubject();

        if (user != null) {
            SecurityContextHolder.getContext().setAuthentication(new
                    UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()));
        }
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            DefaultClaims claim = (DefaultClaims) Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
                    //.getSubject();
            String user = claim.getSubject();
            Date w_expiry = claim.getExpiration();
            if (user != null) {

                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
