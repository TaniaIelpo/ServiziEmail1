package co.develhope.ServiziEmail.api.controllers;

import co.develhope.ServiziEmail.api.entities.NotificationDTO;
import co.develhope.ServiziEmail.entities.Student;
import co.develhope.ServiziEmail.services.EmailService;
import co.develhope.ServiziEmail.services.NotificationService;
import co.develhope.ServiziEmail.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * exposes under the mapping notification an endpoint for sending an email to a specific Student
 *
 * @author Tania Ielpo
 */

@Controller

public class EmailController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    StudentService studentService;


    /**
     * use a try/catch in the dedicated controller
     * @param notificationDTO Body of request
     * @return a Response Entity
     */
    @PostMapping("/notification")

    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            return notificationService.sendNotification(notificationDTO);
        } catch (Exception e) { //if the request is not correct, reply with an error 500 HTTP response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
