package com.challenge.heroes.service;

import com.challenge.heroes.model.HeroEntity;

import java.util.List;
import java.util.Optional;

public interface IHeroService {

    List<HeroEntity> findAll();

    Optional<HeroEntity> findById(Integer id);

    HeroEntity create(HeroEntity hero);

    Boolean update(HeroEntity hero);

    Boolean remove(Integer id);


}
