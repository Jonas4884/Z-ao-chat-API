package com.zaochat.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String SenderName;
    private String toMessage;
    private String content;
    private String status;
    private String date;

}
