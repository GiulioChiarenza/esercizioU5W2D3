package giuliochiarenza.esercizioU5W2D3.repositories;

import giuliochiarenza.esercizioU5W2D3.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogDAO extends JpaRepository<Blog, UUID> {
}
