package com.example.tdd.chap07;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoDebitInfoRepository extends JpaRepository<AutoDebitInfo, String> {

    Optional<AutoDebitInfo> findByUserId(String userId);
}
