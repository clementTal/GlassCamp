package com.example.glasscamp.app.objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Deal {

    private Date date;
    private String shop;
    private float amount;

    public Deal(float amount, String shop) {
        date = new Date();
        this.shop = shop;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString()
    {
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.FRANCE);
        return sdf.format(date);
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
