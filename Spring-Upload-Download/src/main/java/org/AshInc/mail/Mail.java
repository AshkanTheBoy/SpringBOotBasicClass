package org.AshInc.mail;

import lombok.Data;

import java.util.Map;

@Data
public class Mail {
    String to;
    String from;
    String subject;
    String text;
    String template;
    Map<String, Object> properties;
}
