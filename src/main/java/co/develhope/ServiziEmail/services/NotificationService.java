package co.develhope.ServiziEmail.services;

import co.develhope.ServiziEmail.api.entities.NotificationDTO;
import co.develhope.ServiziEmail.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    StudentService studentService;

    @Autowired
    EmailService emailService;

    /**
     * if the id of the Student is already in the list, then send the email to that user
     * if not, reply with a BAD_REQUEST message
     * @param notificationDTO
     * @return a response Entity
     */

    public ResponseEntity<String> sendNotification(NotificationDTO notificationDTO){
        Student studentToSendNotification= studentService.getStudentById(notificationDTO.getContactID());
        System.out.println("Getting the : "+studentToSendNotification);
        if(studentToSendNotification==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the user");
        }
        emailService.sendTo(studentToSendNotification.getEmail(), notificationDTO.getTitle(),notificationDTO.getText());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
