package vn.hcmute.nhom16.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:17 AM
 * Filename : NotFoundException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(){

    }

    public NotFoundException(String message, Throwable cause){super(message,cause);}

    public NotFoundException(String message) {
        super(message);
    }
}
