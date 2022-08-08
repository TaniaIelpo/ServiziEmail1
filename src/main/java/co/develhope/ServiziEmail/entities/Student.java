package co.develhope.ServiziEmail.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tania Ielpo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    /**
     * Student with the following string properties:
     * id
     * name
     * surname
     * email
     */

    private String studentId;
    private String name;
    private String surname;
    private String email;
}
