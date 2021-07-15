package com.example.personalaccount.edu;

public class Edu {

    private String SubjectTitle;
    private String SubjectDate;
    private String SubjectScore;

    //переделать даты и баллы в массивы  или классы

    public Edu(String SubjectTitle){
        this.SubjectTitle = SubjectTitle;


    }
    public Edu(String SubjectDate,String SubjectScore ){
        this.SubjectDate = SubjectDate;
        this.SubjectScore = SubjectScore;

    }

    public String GetSubjectTitle(){ return SubjectTitle;}
    public String GetSubjectDate(){ return SubjectDate;}
    public String GetSubjectScore(){ return SubjectScore;}

    public void SetSubjectTitle(String SubjectTitle){ this.SubjectTitle = SubjectTitle;}
    public void SetSubjectDate(String SubjectDate){ this.SubjectDate = SubjectDate;}
    public void SetSubjectScore(String SubjectScore){ this.SubjectScore = SubjectScore;}

}
