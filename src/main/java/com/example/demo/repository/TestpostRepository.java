package com.example.demo.repository;

import com.example.demo.domain.Testpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestpostRepository extends JpaRepository<Testpost, Long> {
}
