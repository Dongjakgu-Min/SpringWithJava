package xyz.yeongdu.spring.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ApiException extends ResponseStatusException {
    public ApiException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
