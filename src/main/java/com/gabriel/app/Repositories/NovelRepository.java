package com.gabriel.app.Repositories;
import com.gabriel.app.Entities.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Integer> {

}
