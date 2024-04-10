package giuliochiarenza.esercizioU5W2D3.services;


import giuliochiarenza.esercizioU5W2D3.entities.Blog;
import giuliochiarenza.esercizioU5W2D3.exceptions.NotFoundException;
import giuliochiarenza.esercizioU5W2D3.repositories.BlogDAO;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    @Autowired
    private BlogDAO blogDAO;

    public Page<Blog> getBlogList(int page, int size, String sortBy){
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.blogDAO.findAll(pageable);
    }
    public Blog saveBlog(Blog body){
        body.setCover("https://picsum.photos/200/300");
        return blogDAO.save(body);
    }
    public Blog findById(UUID blogId){
       return this.blogDAO.findById(blogId).orElseThrow(()-> new NotFoundException(blogId));
    }

    public Blog findByIdAndUpdate(UUID blogId, Blog updatedBlog){
        Blog found = this.findById(blogId);
                found.setCategory(updatedBlog.getCategory());
                found.setTitle(updatedBlog.getTitle());
                found.setContent(updatedBlog.getContent());
                found.setReadingTime(updatedBlog.getReadingTime());
                found.setAuthor(updatedBlog.getAuthor());
         return this.blogDAO.save(found);
    }

    public void findByIdAndDelete(UUID blogId){
        Blog found = this.findById(blogId);
        this.blogDAO.delete(found);

    }
}
