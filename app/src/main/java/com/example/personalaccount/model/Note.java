package com.example.personalaccount.model;

public class Note {

    private String NoteTitle;
    private String NoteText;

    public Note(String NoteTitle, String NoteText){
        this.NoteText = NoteText;
        this.NoteTitle = NoteTitle;
    }

    public String GetNoteTitle(){ return NoteTitle;}
    public String GetNoteText() {return NoteText;}

    public void SetNoteText(String NoteText){ this.NoteText = NoteText;}
    public void SetNoteTitle (String NoteTitle){this.NoteTitle = NoteTitle;}

}
