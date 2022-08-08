package co.develhope.ServiziEmail.services;

import co.develhope.ServiziEmail.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Tania Ielpo
 */

@Service
public class StudentService {

    /**
     * a list of 4 Students, where the first one is you (with your email)
     */
    List<Student> students= Arrays.asList(
            new Student("1","Tania","Ielpo", "taniaie@tiscali.it"),
            new Student("2", "Giulia", "Rossi", "giuliarossi@gmail.com"),
            new Student("3","Giuseppe","Verdi", "giuseppeverdi@gmail.com"),
            new Student("4", "Mario", "Bianchi", "mari9obianchi@gmail.com")
    );

    /**
     * returns the Student if it's present in the list
     * @param id of student to find
     * @return  the student if present otherwise null
     */

    public Student getStudentById(String id){
        Optional<Student> studentFromDB= students.stream().filter(user -> user.getStudentId().equals(id)).findAny();
        if(studentFromDB.isPresent()){
            return studentFromDB.get();
        }
        return null;
    }
}
