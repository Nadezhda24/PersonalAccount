package com.example.personalaccount.model;

public class Chat {

    private int ChatId;
    private String ChatTitle;

    private int ChatCountUnread;

    public Chat(int ChatId,  String ChatTitle, int ChatCountUnread ){
        this.ChatId = ChatId;
        this.ChatTitle = ChatTitle;
        this.ChatCountUnread = ChatCountUnread;
    }

    public String GetChatTitle(){ return ChatTitle;}
    public int GetChatCountUnread(){ return ChatCountUnread;}
    public int GetChatId(){ return ChatId;}

    public void SetChatTitle(String ChatTitle){ this.ChatTitle = ChatTitle;}
    public void SetChatCountUnread(int ChatCountUnread){ this.ChatCountUnread = ChatCountUnread;}
    public void SetChatId(int ChatId){ this.ChatId = ChatId;}
}
