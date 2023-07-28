package xyz.yeongdu.spring.security.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import xyz.yeongdu.spring.response.AuthExceptionResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthExceptionHandler implements AuthenticationEntryPoint {
    private final ObjectMapper mapper;
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(new AuthExceptionResponse()));
    }
}
