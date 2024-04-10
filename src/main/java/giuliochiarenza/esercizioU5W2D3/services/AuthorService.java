package giuliochiarenza.esercizioU5W2D3.services;

import giuliochiarenza.esercizioU5W2D3.entities.Author;
import giuliochiarenza.esercizioU5W2D3.exceptions.NotFoundException;
import giuliochiarenza.esercizioU5W2D3.repositories.AuthorDAO;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorService {
    @Autowired
   private AuthorDAO authorDAO;
    public Page<Author> getAuthorList(int page, int size, String sortBy){
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return this.authorDAO.findAll(pageable);
    }

    public Author saveAuthor(Author body){
        body.setAvatar("https://ui-avatars.com/api/?name="+ body.getName() + "+" + body.getSurname());
        return authorDAO.save(body);
    }

    public Author findById(UUID authorId){
       return this.authorDAO.findById(authorId).orElseThrow(()-> new NotFoundException(authorId));
    }

    public Author findByIdAndUpdate(UUID authorId, Author updatedAuthor) {
        Author found = this.findById(authorId);
        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        found.setEmail(updatedAuthor.getEmail());
        found.setBirth(updatedAuthor.getBirth());
        found.setAvatar("https://ui-avatars.com/api/?name="+ updatedAuthor.getName() + "+" + updatedAuthor.getSurname());
        return this.authorDAO.save(found);

    }

    public void findByIdAndDelete(UUID authorId){
        Author found = this.findById(authorId);
        this.authorDAO.delete(found);

    }
}
