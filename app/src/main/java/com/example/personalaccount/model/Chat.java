package com.example.personalaccount.model;

public class Chat {

    private int ChatId;
    private String ChatTitle;
    private String ChatType;
    private int ChatCountUnread;

    public Chat(){
        this.ChatId = -1;
        this.ChatType = "persanal";
        this.ChatTitle ="";
        this.ChatCountUnread = 0;
    }

    public Chat(int ChatId, String ChatType, String ChatTitle, int ChatCountUnread ){
        this.ChatId = ChatId;
        this.ChatType = ChatType;
        this.ChatTitle = ChatTitle;
        this.ChatCountUnread = ChatCountUnread;
    }

    public  String GetChatType(){return ChatType;}
    public String GetChatTitle(){ return ChatTitle;}
    public int GetChatCountUnread(){ return ChatCountUnread;}
    public int GetChatId(){ return ChatId;}

    public void setChatType(String ChatType) { this.ChatType = ChatType;}
    public void SetChatTitle(String ChatTitle){ this.ChatTitle = ChatTitle;}
    public void SetChatCountUnread(int ChatCountUnread){ this.ChatCountUnread = ChatCountUnread;}
    public void SetChatId(int ChatId){ this.ChatId = ChatId;}
}
