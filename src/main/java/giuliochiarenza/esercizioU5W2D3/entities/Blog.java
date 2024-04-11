package giuliochiarenza.esercizioU5W2D3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Author author;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public Blog( Author author, String category, String title, String cover, String content, int readingTime) {

        this.author = author;
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.readingTime = readingTime;
    }
}
