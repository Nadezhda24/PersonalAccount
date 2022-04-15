package com.example.personalaccount.model;

public class Task {
    private int TaskId;
    private String TaskTopic;
    private String TaskDate;
    private String TaskContent;
    private String TaskStatus;
    private String File;


    public Task(int TaskId, String TaskTopic, String TaskDate, String TaskContent, String TaskStatus){
        this.TaskId = TaskId;
        this.TaskTopic = TaskTopic;
        this.TaskDate = TaskDate;
        this.TaskContent = TaskContent;
        this.TaskStatus = TaskStatus;
    }

    public int GetTaskId(){return TaskId;}
    public String GetTaskTopic(){ return TaskTopic;}
    public String GetTaskDate(){ return TaskDate;}
    public String GetTaskContent(){ return TaskContent;}
    public String GetTaskStatus(){ return TaskStatus;}

    public void SetTaskId(int TaskId){this.TaskId = TaskId;}
    public void SetTaskTopic(String TaskTopic){ this.TaskTopic = TaskTopic;}
    public void SetTaskDate(String TaskDate){ this.TaskDate = TaskDate;}
    public void SetTaskContent(String TaskContent){ this.TaskContent = TaskContent;}
    public void SetTaskStatus(String TaskStatus){ this.TaskStatus = TaskStatus;}
}
