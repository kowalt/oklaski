package com.example.oklaski.repositories;

import com.example.oklaski.entites.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

    @Query("SELECT COUNT(b) FROM Bug b JOIN b.device d WHERE d.description in :descriptions AND b.tester.id = :testerId")
    Integer countByDeviceAndTester(List<String> descriptions, Long testerId);

    @Query("SELECT COUNT(b) FROM Bug b WHERE b.tester.id = :testerId")
    Integer countByTester(Long testerId);
}
