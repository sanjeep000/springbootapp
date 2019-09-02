package com.example.location.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.location.model.Location;



public interface LocationRepository extends JpaRepository<Location, Long> {

}
