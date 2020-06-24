package com.SCUBA.diver.repositories;

import com.SCUBA.diver.models.Diver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiverRepository extends JpaRepository<Diver, Long> {
}
