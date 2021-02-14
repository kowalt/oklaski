package com.example.oklaski.repositories;

import com.example.oklaski.entites.Bug;
import com.example.oklaski.entites.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

    @Query("SELECT COUNT(*) FROM Device d JOIN Tester t ")
    Integer countByDeviceAndTester(List<String> description, Long testerId);
}
