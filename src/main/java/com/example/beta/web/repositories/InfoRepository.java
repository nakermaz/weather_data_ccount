package com.example.beta.web.repositories;

import com.example.beta.web.models.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Integer> {

        @Query(value = "select * from info u where u.raining = true ", nativeQuery = true)
        List<Info> findRainingDays();
}
