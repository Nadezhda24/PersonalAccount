package com.example.personalaccount;

import javax.xml.transform.sax.TemplatesHandler;

public class ScheduleDay {
    private String LessonName;
    private String TeacherName;

    public ScheduleDay(String LessonName, String TeacherName){
        this.LessonName =LessonName;
        this.TeacherName = TeacherName;
    }

    public String GetLessonName(){
        return this.LessonName;
    }

    public String GetTeacherName(){
        return this.TeacherName;
    }
    public void SetLessonName(String LessonName){
        this.LessonName = LessonName;
    }
    public void SetTeacherName(String TeacherName){
        this.TeacherName = TeacherName;
    }
}

