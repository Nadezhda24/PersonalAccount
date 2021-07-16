package com.example.personalaccount.message;

public class Chat {

    private String ChatTitle;
    private String ChatText;
    private String ChatCountUnread;

    public Chat(String ChatTitle, String ChatText, String ChatCountUnread ){
        this.ChatTitle = ChatTitle;
        this.ChatText = ChatText;
        this.ChatCountUnread = ChatCountUnread;
    }

    public String GetChatTitle(){ return ChatTitle;}
    public String GetChatText(){ return ChatText;}
    public String GetChatCountUnread(){ return ChatCountUnread;}

    public void SetChatTitle(String ChatTitle){ this.ChatTitle = ChatTitle;}
    public void SetChatText(String ChatText){ this.ChatTitle = ChatText;}
    public void SetChatCountUnread(String ChatCountUnread){ this.ChatCountUnread = ChatCountUnread;}
}
