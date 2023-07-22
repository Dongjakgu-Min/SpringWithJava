package xyz.yeongdu.spring.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MultiResponseDto<T> {
    private List<T> data;
}
