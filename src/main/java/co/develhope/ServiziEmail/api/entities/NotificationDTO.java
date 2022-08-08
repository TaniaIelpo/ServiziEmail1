package co.develhope.ServiziEmail.api.entities;

import lombok.Data;

/**
 *
 * @author Tania Ielpo
 */

@Data
public class NotificationDTO {

    /**
     *  NotificationDTO that consists of the following strings:
     * contactId
     * title
     * text
     */
    /** ContactId to send data*/
    private String contactID;
    /**Title of the notification*/
    private String title;
    /** Text of the notification*/
    private String text;
}
