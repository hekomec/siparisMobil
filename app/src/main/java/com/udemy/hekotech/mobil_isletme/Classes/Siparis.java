package com.udemy.hekotech.mobil_isletme.Classes;

/**
 * Created by hekotech on 20.01.2019.
 */

public class Siparis {
    String order,total,id;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order_) {
        order = order_;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total_) {
        total = total_;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Siparis(String order, String total, String id){
        this.order=order;
        this.total=total;
        this.id = id;
    }
    public Siparis(){}

}
