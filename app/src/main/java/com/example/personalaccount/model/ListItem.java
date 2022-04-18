package com.example.personalaccount.model;

public class ListItem {
    private String Item;

    public ListItem(String Item){
        this.Item = Item;
    }

    public String GetItem(){ return Item;}
    public void SetItem(String Item){ this.Item = Item;}

}
