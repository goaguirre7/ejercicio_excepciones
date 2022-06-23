package com.santander.ejercicio_excepciones.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;

@Slf4j
public class EmailUtil {

    public static void sendEmail(String destination, String title, String body) {
        try {
            // sends an email
            log.info("Email sent");
        } catch (MailAuthenticationException e) {
            // what should I do if I can't auth the mail?
        } catch (MailSendException e) {
            // what should I do if the email can't be sent?
        }
    }

}
