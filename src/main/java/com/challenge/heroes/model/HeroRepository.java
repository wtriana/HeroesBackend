package com.challenge.heroes.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroRepository extends JpaRepository<HeroEntity, Integer> {

}
