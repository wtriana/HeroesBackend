package com.challenge.heroes.service;

import com.challenge.heroes.model.HeroEntity;
import com.challenge.heroes.model.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements IHeroService {

    private final Logger LOGGER = LoggerFactory.getLogger(HeroServiceImpl.class);

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<HeroEntity> findAll() {

        return heroRepository.findAll();
    }

    @Override
    public Optional<HeroEntity> findById(Integer id) {

        return heroRepository.findById(id);
    }

    @Override
    public HeroEntity create(HeroEntity hero) {

        return heroRepository.save(hero);
    }

    @Override
    public Boolean update(HeroEntity heroUpdated) {
        if (heroRepository.findById(heroUpdated.getId()).isPresent()) {
            HeroEntity heroToUpdate = new HeroEntity();
            heroToUpdate.setId(heroUpdated.getId());
            heroToUpdate.setBio(heroUpdated.getBio());
            heroToUpdate.setName(heroUpdated.getName());
            heroToUpdate.setImage(heroUpdated.getImage());
            heroToUpdate.setRelease(heroUpdated.getRelease());
            heroToUpdate.setFamilyId(heroUpdated.getFamilyId());

            heroRepository.save(heroToUpdate);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    @Override
    public Boolean remove(Integer id) {
        if (heroRepository.findById(id).isPresent()) {
            heroRepository.deleteById(id);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
