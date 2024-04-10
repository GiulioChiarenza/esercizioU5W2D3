package giuliochiarenza.esercizioU5W2D3.controllers;

import giuliochiarenza.esercizioU5W2D3.entities.Blog;
import giuliochiarenza.esercizioU5W2D3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    private Page<Blog> getAllBlog(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String sortBy){
        return this.blogService.getBlogList(page, size, sortBy);
    }
    @GetMapping("/{blogId}")
    private Blog findByBlogId(@PathVariable UUID blogId) {
        return this.blogService.findById(blogId);
    }
    @PostMapping
    private Blog saveBlog(@RequestBody Blog body){
        return this.blogService.saveBlog(body);
    }
    @PutMapping("/{blogId}")
    private Blog findByIdAndUpdate(@PathVariable UUID blogId, @RequestBody Blog body){
        return  this.blogService.findByIdAndUpdate(blogId, body);
    }
    @DeleteMapping("/{blogId}")
    private void findBlogByIdAndDelete(@PathVariable UUID blogId){
        this.blogService.findByIdAndDelete(blogId);
    }
}
