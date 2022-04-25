package com.example.personalaccount.model;

public class Chat {

    private String ChatTitle;

    private String ChatCountUnread;

    public Chat(String ChatTitle, String ChatCountUnread ){
        this.ChatTitle = ChatTitle;

        this.ChatCountUnread = ChatCountUnread;
    }

    public String GetChatTitle(){ return ChatTitle;}
    public String GetChatCountUnread(){ return ChatCountUnread;}

    public void SetChatTitle(String ChatTitle){ this.ChatTitle = ChatTitle;}
    public void SetChatCountUnread(String ChatCountUnread){ this.ChatCountUnread = ChatCountUnread;}
}
