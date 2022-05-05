package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Wed, 5/4/2022
 * Time     : 9:42 PM
 * Filename : Type
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "type")
public class Type {
    @Id
    private String id;
    private String name;
}
