package xyz.yeongdu.spring.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.yeongdu.spring.response.AccessDeniedResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AccessDeniedExceptionHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    private final ObjectMapper mapper;
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setStatus(403);
        response.getWriter().write(mapper.writeValueAsString(new AccessDeniedResponse()));
    }
}
