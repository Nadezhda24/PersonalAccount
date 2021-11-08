package com.example.personalaccount.model;

public class Task {
    private String TaskTopic;
    private String TaskDate;
    private String TaskContent;
    private String TaskStatus;

    public Task(String TaskTopic, String TaskDate, String TaskContent, String TaskStatus){
        this.TaskTopic = TaskTopic;
        this.TaskDate = TaskDate;
        this.TaskContent = TaskContent;
        this.TaskStatus = TaskStatus;
    }

    public String GetTaskTopic(){ return TaskTopic;}
    public String GetTaskDate(){ return TaskDate;}
    public String GetTaskContent(){ return TaskContent;}
    public String GetTaskStatus(){ return TaskStatus;}

    public void SetTaskTopic(String TaskTopic){ this.TaskTopic = TaskTopic;}
    public void SetTaskDate(String TaskDate){ this.TaskDate = TaskDate;}
    public void SetTaskContent(String TaskContent){ this.TaskContent = TaskContent;}
    public void SetTaskStatus(String TaskStatus){ this.TaskStatus = TaskStatus;}
}
