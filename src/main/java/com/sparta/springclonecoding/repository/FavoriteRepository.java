package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

}
