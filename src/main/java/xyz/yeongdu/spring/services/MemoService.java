package xyz.yeongdu.spring.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.yeongdu.spring.repositories.MemoRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemoService {
    private MemoRepository memoRepository;
}
