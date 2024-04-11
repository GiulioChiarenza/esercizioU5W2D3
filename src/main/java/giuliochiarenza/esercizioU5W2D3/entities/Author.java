package giuliochiarenza.esercizioU5W2D3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int birth;
    private String avatar;


    public Author( String name, String surname, String email, int birth, String avatar) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birth = birth;
        this.avatar = avatar;
    }
}
