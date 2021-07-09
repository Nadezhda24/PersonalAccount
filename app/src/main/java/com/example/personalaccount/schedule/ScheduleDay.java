package com.example.personalaccount.schedule;

import java.util.Date;

import javax.xml.transform.sax.TemplatesHandler;

public class ScheduleDay {

    private String LessonNumder;
    private String LessonStart;
    private String LessonEnd;
    private String LessonName;
    private String LessonType;
    private String LessonRoom;
    private String LessonTeacher;

    public ScheduleDay(String LessonNumder, String LessonStart, String LessonEnd,
                       String LessonName, String LessonType,
                       String LessonRoom, String LessonTeacher ){
       this.LessonNumder = LessonNumder;
       this.LessonStart = LessonStart;
       this.LessonEnd = LessonEnd;
       this.LessonName = LessonName;
       this.LessonType = LessonType;
       this.LessonRoom = LessonRoom;
       this.LessonTeacher = LessonTeacher;
    }

    public String GetLessonNumder(){ return LessonNumder;}
    public String GetLessonStart() {return LessonStart;}
    public String GetLessonEnd() {return LessonEnd;}
    public String GetLessonName() {return LessonName;}
    public String GetLessonType() {return LessonType;}
    public String GetLessonRoom() {return LessonRoom;}
    public String GetLessonTeacher() {return LessonTeacher;}

    public void SetLessonNumder(String LessonNumder){ this.LessonNumder = LessonNumder;}
    public void SetLessonStart (String LessonStart){this.LessonStart = LessonStart;}
    public void SetLessonEnd (String LessonEnd) {this.LessonEnd = LessonEnd;}
    public void SetLessonName (String LessonName) {this.LessonName = LessonName;}
    public void SetLessonType (String LessonType) {this.LessonType = LessonType;}
    public void SetLessonRoom (String LessonRoom) {this.LessonRoom = LessonRoom;}
    public void SetLessonTeacher (String LessonTeacher) {this.LessonTeacher = LessonTeacher;}


}

