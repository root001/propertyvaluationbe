package com.mcb.abdulbasit.valuation.repository;

import com.mcb.abdulbasit.valuation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
