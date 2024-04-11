package giuliochiarenza.esercizioU5W2D3.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
@Getter
public class BadRequestException extends RuntimeException{
    private List<ObjectError> errorslist;
    public BadRequestException(String message){
        super(message);
    }
    public BadRequestException(List<ObjectError> errorsList){
        super("errori nella validazione del payload");
        this.errorslist = errorsList;
    }

}
