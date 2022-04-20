package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByUserid(Long userid);
    Optional<Favorite> findByUseridAndPostid(Long userid, Long postid);
    void deleteByUseridAndPostid(Long userid, Long postid);
    List<Favorite> findAllByPostid(Long postid);
}
