package com.training.project.Repository;

import com.training.project.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    List<Events> findTop5ByEventDateAfterOrderByEventDateAsc(LocalDate date);
}
