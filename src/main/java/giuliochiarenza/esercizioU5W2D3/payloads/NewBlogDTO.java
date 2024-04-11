package giuliochiarenza.esercizioU5W2D3.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class NewBlogDTO {
    @NotEmpty(message = "la categoria è obbligatoria")
    private String category;
    @NotEmpty(message = "il titolo è obbligatorio")
    @Size(min = 3, max = 100, message = "Il titolo deve essere compreso tra i 3 e i 100 caratteri")
    private String title;
    @NotEmpty(message = "la cover è obbligatoria")
    private String cover;
    @NotEmpty(message = "il contenuto è obbligatorio")
    private  String content;
    @NotEmpty(message = "il tempo di lettura è obbligatorio")
    private int readingTime;
    private UUID authorId;
}
