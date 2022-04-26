package com.example.personalaccount.model;

import android.renderscript.ScriptGroup;

public class Message {
    String UserName;
    String Text;
    String Time;
    int Input;

    public Message(String UserName, String Time, String Text, int Input){
        this.UserName = UserName;
        this.Text = Text;
        this.Time = Time;
        this.Input =Input;
    }
    public Message(String Time, String Text, int Input){
        this.Text = Text;
        this.Time = Time;
        this.Input = Input;
    }

    public String GetUserName(){return UserName;}
    public String GetText(){return Text;}
    public String GetTime(){return Time;}
    public int GetInput(){return Input;}

    public void SetUserName(String UserName){this.UserName = UserName;}
    public void SetText(String Text){this.Text = Text;}
    public void SetTime(String Time){this.Time = Time;}
    public void SetInput(int Input){this.Input = Input;}
}
