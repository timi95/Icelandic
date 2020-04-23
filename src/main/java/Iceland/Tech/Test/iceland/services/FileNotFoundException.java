package Iceland.Tech.Test.iceland.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import Iceland.Tech.Test.iceland.responses.StorageException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends StorageException {

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}