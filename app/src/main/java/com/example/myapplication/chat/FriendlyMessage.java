
package com.example.myapplication.chat;

public class FriendlyMessage {

    private String text;
    private String name;


    public FriendlyMessage() {
    }

    public FriendlyMessage(String text, String name) {
        this.text = text;
        this.name = name;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
