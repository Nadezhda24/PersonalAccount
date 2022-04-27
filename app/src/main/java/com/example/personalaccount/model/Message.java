package com.example.personalaccount.model;

import java.util.List;

public class Message {
    String UserName;
    String Text;
    String Time;
    int Input;
    int IsRead;
    List<File> Files;

    public Message(String UserName, String Time, String Text, int Input,   List<File> Files){
        this.UserName = UserName;
        this.Text = Text;
        this.Time = Time;
        this.Input =Input;
        this.Files = Files;
    }
    public Message(String Time, String Text, int Input,  int IsRead, List<File> Files){
        this.Text = Text;
        this.Time = Time;
        this.Input = Input;
        this.IsRead =IsRead;
        this.Files = Files;
    }

    public String GetUserName(){return UserName;}
    public String GetText(){return Text;}
    public String GetTime(){return Time;}
    public int GetInput(){return Input;}
    public int GetIsRead(){return IsRead;}
    public List<File> GetFiles(){return Files;}

    public void SetUserName(String UserName){this.UserName = UserName;}
    public void SetText(String Text){this.Text = Text;}
    public void SetTime(String Time){this.Time = Time;}
    public void SetInput(int Input){this.Input = Input;}
    public void SetIsRead(int IsRead){this.IsRead = IsRead;}
    public void SetFiles(List<File> Files) {this.Files = Files;}
}
