package com.example.personalaccount.model;

public class ScheduleExam {

    private String LessonDate;
    private String LessonTime;
    private String LessonName;
    private String LessonType;
    private String LessonRoom;
    private String LessonTeacher;

    public ScheduleExam(String LessonDate, String LessonTime,
                        String LessonName, String LessonType,
                        String LessonRoom, String LessonTeacher ){
       this.LessonDate = LessonDate;
       this.LessonTime = LessonTime;
       this.LessonName = LessonName;
       this.LessonType = LessonType;
       this.LessonRoom = LessonRoom;
       this.LessonTeacher = LessonTeacher;
    }

    public String GetLessonDate(){ return LessonDate;}
    public String GetLessonTime() {return LessonTime;}
    public String GetLessonName() {return LessonName;}
    public String GetLessonType() {return LessonType;}
    public String GetLessonRoom() {return LessonRoom;}
    public String GetLessonTeacher() {return LessonTeacher;}

    public void SetLessonDate(String LessonDate){ this.LessonDate = LessonDate;}
    public void SetLessonTime (String LessonTime){this.LessonTime = LessonTime;}
    public void SetLessonName (String LessonName) {this.LessonName = LessonName;}
    public void SetLessonType (String LessonType) {this.LessonType = LessonType;}
    public void SetLessonRoom (String LessonRoom) {this.LessonRoom = LessonRoom;}
    public void SetLessonTeacher (String LessonTeacher) {this.LessonTeacher = LessonTeacher;}


}

