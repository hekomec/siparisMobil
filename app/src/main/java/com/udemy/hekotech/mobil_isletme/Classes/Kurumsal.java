package com.udemy.hekotech.mobil_isletme.Classes;

/**
 * Created by hekotech on 20.01.2019.
 */

public class Kurumsal {
    String date,exp,message,name,id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kurumsal(String date, String exp, String message, String name, String id){
        this.date=date;
        this.exp=exp;
        this.message=message;
        this.name=name;
        this.id = id;
    }
    public Kurumsal(){

    }
}
