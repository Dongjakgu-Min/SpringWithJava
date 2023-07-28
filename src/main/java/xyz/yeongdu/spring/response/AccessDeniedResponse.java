package xyz.yeongdu.spring.response;

public class AccessDeniedResponse extends ErrorResponse{

    public AccessDeniedResponse() {
        super(403, "권한이 부족합니다.");
    }
}
