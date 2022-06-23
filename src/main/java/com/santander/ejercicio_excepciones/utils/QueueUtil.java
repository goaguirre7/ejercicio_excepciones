package com.santander.ejercicio_excepciones.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueUtil {

    public static void queue(String message) {
        try {
            // adds it to the queue
            log.info("Message queued");
        } catch (Exception e) {
            // what should I do if the message can't be queued?
        }
    }

}
