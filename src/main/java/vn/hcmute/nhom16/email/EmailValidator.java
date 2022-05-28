package vn.hcmute.nhom16.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Fri, 5/27/2022
 * Time     : 18:38
 * Filename : EmailValidator
 */
@Service

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: Regex to validate email
        return true;
    }
}
