package com.gabriel.app.Controllers;
import com.gabriel.app.Entities.Manga;
import com.gabriel.app.Repositories.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/manga")
public class MangaController {
    @Autowired
    private MangaRepository mangaRepository;
    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Manga getMangaById(@PathVariable int id) {
        return mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
    }
    @PostMapping
    public Manga addManga(@RequestBody Manga manga) {
        return mangaRepository.save(manga);
    }
    @PutMapping("/{id}")
    public Manga updateManga(@PathVariable int id, @RequestBody Manga manga) {
        Manga manga1 = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        manga1.setTitle(manga.getTitle());
        manga1.setAuthor(manga.getAuthor());
        manga1.setGenre(manga.getGenre());
        manga1.setPublisher(manga.getPublisher());
        manga1.setDescription(manga.getDescription());
        return mangaRepository.save(manga1);
    }
    @DeleteMapping("/{id}")
    public String deleteManga(@PathVariable int id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        mangaRepository.delete(manga);
        return "manga deleted";
    }
}
