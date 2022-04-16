package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findById(Long userId);

    Optional<Favorite> findByUserid(Long userid);
}
