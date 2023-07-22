package xyz.yeongdu.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yeongdu.spring.models.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {}
