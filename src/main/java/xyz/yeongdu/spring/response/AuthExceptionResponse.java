package xyz.yeongdu.spring.response;

public class AuthExceptionResponse extends ErrorResponse{
    public AuthExceptionResponse() {
        super(401, "토큰이 올바르지 않습니다.");
    }
}
