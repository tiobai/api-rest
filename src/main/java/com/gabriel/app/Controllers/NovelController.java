package com.gabriel.app.Controllers;
import com.gabriel.app.Entities.Novel;
import com.gabriel.app.Repositories.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/novel")
public class NovelController {
    @Autowired
    private NovelRepository novelRepository;
    @GetMapping
    public List<Novel> getAllNovels() {
        return novelRepository.findAll();
    }
    @GetMapping("/{id}")
    public Novel getNovelById(@PathVariable int id) {
        return novelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such novel"));
    }
    @PostMapping
    public Novel addNovel(@RequestBody Novel novel) {
        return novelRepository.save(novel);
    }
    @PutMapping("/{id}")
    public Novel updateNovel(@PathVariable int id, @RequestBody Novel novel) {
        Novel novel1 = novelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such novel"));
        novel1.setTitle(novel.getTitle());
        novel1.setAuthor(novel.getAuthor());
        novel1.setPublisher(novel.getPublisher());
        novel1.setDescription(novel.getDescription());
        return novelRepository.save(novel1);
    }
    @DeleteMapping("/{id}")
    public String deleteNovel(@PathVariable int id) {
            Novel novel = novelRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no such novel"));
            novelRepository.delete(novel);
            return "Novel deleted";
    }
}
