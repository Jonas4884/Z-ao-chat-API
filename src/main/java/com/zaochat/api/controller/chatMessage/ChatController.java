package com.zaochat.api.controller.chatMessage;


import com.zaochat.api.model.chatMessage.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage (@Payload Message message){
        return  message;
    }

    @MessageMapping("/private-message")
    public Message addMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getToMessage(),"/private",message);
        return message;
    }

}
