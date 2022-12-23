package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Plot;

public interface PlotRepository extends JpaRepository<Plot, Long> {

}
