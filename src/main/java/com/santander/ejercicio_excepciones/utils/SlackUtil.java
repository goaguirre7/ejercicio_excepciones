package com.santander.ejercicio_excepciones.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlackUtil {

    public static void sendMessage(String channel, String message) {
        try {
            // sends a message
            log.info("Slack message sent");
        } catch (Exception e) {
            // what should I do if the message can't be sent to Slack?
        }
    }

}
