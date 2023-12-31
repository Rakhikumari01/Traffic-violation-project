package com.codewithrakhi.traffic.repositories;

import com.codewithrakhi.traffic.entity.Penalty;
import com.codewithrakhi.traffic.entity.User;
import com.codewithrakhi.traffic.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenaltyRepo extends JpaRepository<Penalty, Integer> {
    List<Penalty> findByUser(User user);

}
