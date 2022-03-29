package com.example.personalaccount.model;

import java.io.Serializable;

public class Status  implements Serializable {
    private String StatusType;
    private String StatusDate;
    private String StatusComment;
    private String StatusFile;

    public Status( String StatusType, String StatusDate, String StatusComment, String StatusFile){
        this.StatusType = StatusType;
        this.StatusDate = StatusDate;
        this.StatusComment = StatusComment;
        this.StatusFile = StatusFile;
    }

    public String GetStatusType(){ return StatusType;}
    public String GetStatusDate(){ return StatusDate;}
    public String GetStatusComment(){ return StatusComment;}
    public String GetStatusFile(){ return StatusFile;}

    public void SetStatusType(String StatusType){ this.StatusType = StatusType;}
    public void SetStatusDate(String StatusDate){ this.StatusDate = StatusDate;}
    public void SetStatusComment(String StatusComment){ this.StatusComment = StatusComment;}
    public void SetStatusFile(String StatusFile){ this.StatusFile = StatusFile;}
}
