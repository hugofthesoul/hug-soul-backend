package hugsoul.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UnsupportedCountryException extends Exception {
    private static final long serialVersionUID = -1214371712865160165L;

    public UnsupportedCountryException(String message) {
        super(message);
    }
}
