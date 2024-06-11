package com.example.chatapp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ChatBean implements Serializable {
    private String username;
    private String message;
    private List<String> chatMessages = new ArrayList<>();
    private boolean loggedIn = false;

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getChatMessages() {
        return chatMessages;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login() {
        loggedIn = true;
    }

    public void sendMessage() {
        if (message != null && !message.trim().isEmpty()) {
            chatMessages.add(username + ": " + message);
            message = "";
        }
    }

    public void logout() {
        loggedIn = false;
        username = null;
        message = null;
        chatMessages.clear();
    }
}
