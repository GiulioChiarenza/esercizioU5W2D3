package giuliochiarenza.esercizioU5W2D3.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewAuthorDTO(@NotEmpty(message = "il nome è obbligatorio")
                            @Size(min = 3, max = 20, message = "il nome deve essere compreso tra i 3 e i 20 caratteri")
                            String name,
                           @NotEmpty(message = "Il cognome è obbligatorio")
                            @Size(min = 3, max = 20, message = "Il cognome deve essere compreso tra i 3 e i 20 caratteri")
                            String surname,
                           @NotEmpty(message = "L'email è obbligatoria")
                            @Email(message = "L'email inserita non è valida")
                            String email,
                           @NotEmpty(message = "La password è obbligatoria")
                            @Size(min = 4, message = "La password deve avere come minimo 8 caratteri")
                            int birth) {
}
