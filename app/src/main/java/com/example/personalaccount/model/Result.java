package com.example.personalaccount.model;

public class Result {

    private String SubjectName;
    private String SubjectTeacher;
    private String SubjectType;
    private String SubjectResult;

    public Result(String SubjectName, String SubjectTeacher,
                  String SubjectType, String SubjectResult ){
        this.SubjectName = SubjectName;
        this.SubjectResult = SubjectResult;
        this.SubjectType = SubjectType;
        this.SubjectTeacher = SubjectTeacher;
    }

    public String GetSubjectName(){ return SubjectName;}
    public String GetSubjectTeacher() {return SubjectTeacher;}
    public String GetSubjectType() {return SubjectType;}
    public String GetSubjectResult() {return SubjectResult;}

    public void SetSubjectName(String SubjectName){ this.SubjectName = SubjectName;}
    public void SetSubjectTeacher (String SubjectTeacher){this.SubjectTeacher = SubjectTeacher;}
    public void SetSubjectType(String SubjectType) {this.SubjectType = SubjectType;}
    public void SetSubjectResult (String SubjectResult) {this.SubjectResult = SubjectResult;}
}
