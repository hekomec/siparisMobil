package com.udemy.hekotech.mobil_isletme.Classes;

/**
 * Created by hekotech on 20.01.2019.
 */

public class Iletisim {
    String date,many,message,name,id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMany() {
        return many;
    }

    public void setMany(String many) {
        this.many = many;
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

    public Iletisim(String date, String many, String message, String name, String id){
        this.date=date;
        this.many=many;
        this.message=message;
        this.name=name;
        this.id = id;
    }

    public Iletisim(){

    }
}
