package xyz.yeongdu.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserAlreadyExistException extends ApiException{
    public UserAlreadyExistException() {
        super(HttpStatus.CONFLICT, "이미 사용자가 존재합니다.");
    }
}
