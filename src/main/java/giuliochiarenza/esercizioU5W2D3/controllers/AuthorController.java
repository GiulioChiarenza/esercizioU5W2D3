package giuliochiarenza.esercizioU5W2D3.controllers;

import giuliochiarenza.esercizioU5W2D3.entities.Author;
import giuliochiarenza.esercizioU5W2D3.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping
    private Page<Author> getAllAuthor(@RequestParam(defaultValue = "0")int page,
                                      @RequestParam(defaultValue = "10")int size,
                                      @RequestParam(defaultValue = "name")String sortBy){
        return this.authorService.getAuthorList(page, size, sortBy);
    }
    @GetMapping("/{authorId}")
    private Author findByAuthorId(@PathVariable UUID authorId) {
        return this.authorService.findById(authorId);
    }
    @PostMapping
    private Author saveAuthor(@RequestBody Author body){
        return this.authorService.saveAuthor(body);
    }
    @PutMapping("/{authorId}")
    private Author findByIdAndUpdate(@PathVariable UUID authorId, @RequestBody Author body){
        return  this.authorService.findByIdAndUpdate(authorId, body);
    }
    @DeleteMapping("/{authorId}")
    private void findAuthorByIdAndDelete(@PathVariable UUID authorId){
        this.authorService.findByIdAndDelete(authorId);
    }
}
