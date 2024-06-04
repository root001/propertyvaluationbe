package com.mcb.abdulbasit.valuation.repository;

import com.mcb.abdulbasit.valuation.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

    @Query("select fosReferenceNo from facility order by created_at desc limit 1")
    Optional<String> findLastFacilityReference();
}
