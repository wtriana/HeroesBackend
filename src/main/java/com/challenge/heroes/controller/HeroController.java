package com.challenge.heroes.controller;

import com.challenge.heroes.model.HeroEntity;
import com.challenge.heroes.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("hero")
public class HeroController {

    @Autowired
    private IHeroService heroService;

    @GetMapping("/health")
    public String health() {
        return "Everything is fine here!";
    }

    @GetMapping("/")
    public ResponseEntity<List<HeroEntity>> getAll() {
        List<HeroEntity> heroes = heroService.findAll();

        return new ResponseEntity<>(heroes, heroes.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HeroEntity>> getById(@PathVariable Integer id) {
        Optional<HeroEntity> hero = heroService.findById(id);

        return new ResponseEntity<>(hero, hero.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<HeroEntity> createHero(@RequestBody HeroEntity hero) {
        HeroEntity heroEntity = heroService.create(hero);

        return new ResponseEntity<>(heroEntity, Objects.isNull(heroEntity) ? HttpStatus.NO_CONTENT :
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Boolean> updateHero(@RequestBody HeroEntity hero) {
        return new ResponseEntity<>(heroService.update(hero), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteHero(@PathVariable Integer id) {
        return new ResponseEntity<>(heroService.remove(id), HttpStatus.NO_CONTENT);
    }
}
