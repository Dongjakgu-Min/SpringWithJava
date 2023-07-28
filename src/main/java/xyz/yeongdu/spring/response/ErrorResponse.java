package xyz.yeongdu.spring.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private Integer code;
    private String message;
}
