package com.challenge.heroes.service;

import com.challenge.heroes.model.HeroEntity;
import com.challenge.heroes.model.HeroRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class HeroServiceImplTest {

    @Mock
    HeroRepository heroRepository;

    @InjectMocks
    HeroServiceImpl heroService;

    private HeroEntity heroEntity = new HeroEntity();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        heroEntity.setId(1);
        heroEntity.setName("name");
        heroEntity.setBio("bio");
        heroEntity.setRelease("1990-02-01");
        heroEntity.setImage("image");
        heroEntity.setFamilyId(1);
    }

    @Test
    public void findAll() {
        List<HeroEntity> heroes = new ArrayList<>();
        HeroEntity hero1 = heroEntity;
        heroes.add(hero1);
        when(heroRepository.findAll()).thenReturn(heroes);

        List<HeroEntity> result = heroService.findAll();
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void findById() {
        when(heroRepository.findById(anyInt())).thenReturn(Optional.ofNullable(heroEntity));

        Optional<HeroEntity> hero = heroService.findById(1);
        Assert.assertTrue(hero.isPresent());
    }

    @Test
    public void create() {
        when(heroRepository.save(any(HeroEntity.class))).thenReturn(new HeroEntity());

        HeroEntity heroCreated = heroService.create(heroEntity);
        Assert.assertNotNull(heroCreated);
    }

    @Test
    public void update() {
        when(heroRepository.findById(anyInt())).thenReturn(Optional.ofNullable(heroEntity));
        when(heroRepository.save(any(HeroEntity.class))).thenReturn(null);

        Boolean result = heroService.update(heroEntity);
        Assert.assertTrue(result);
    }

    @Test
    public void updateNotFound() {
        when(heroRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        Boolean result = heroService.update(heroEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void remove() {
        when(heroRepository.findById(anyInt())).thenReturn(Optional.ofNullable(heroEntity));

        Boolean result = heroService.remove(1);
        Assert.assertTrue(result);
    }

    @Test
    public void removeNotFound() {
        when(heroRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        Boolean result = heroService.remove(1);
        Assert.assertFalse(result);
    }
}