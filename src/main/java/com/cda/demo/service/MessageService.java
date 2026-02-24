package com.cda.demo.service;

import com.cda.demo.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageModel messageModel;

    public void helloWorld() {
        messageModel.setMessage("Hello World!");
        System.out.println(messageModel);
    }
}
