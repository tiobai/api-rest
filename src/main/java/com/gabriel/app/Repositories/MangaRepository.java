package com.gabriel.app.Repositories;
import com.gabriel.app.Entities.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
