package hugsoul.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UnsupportedCategoryException extends Exception {
    private static final long serialVersionUID = -1214371712865160165L;

    public UnsupportedCategoryException(String message) {
        super(message);
    }
}
