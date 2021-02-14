package com.example.oklaski.repositories;

import com.example.oklaski.entites.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesterRepository extends JpaRepository<Tester, Long> {
    List<Tester> findByCountryIn(List<String> countries);
}
