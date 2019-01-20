package com.udemy.hekotech.mobil_isletme.Classes;

/**
 * Created by hekotech on 20.01.2019.
 */

public class Siparis {
    String order,total;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        order = order;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        total = total;
    }

    public Siparis(String order, String total){
        this.order=order;
        this.total=total;
    }
    public Siparis(){}

}
