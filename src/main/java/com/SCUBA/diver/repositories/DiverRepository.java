package com.SCUBA.diver.repositories;

import com.SCUBA.diver.models.Diver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiverRepository extends JpaRepository<Diver, Long> {
}
