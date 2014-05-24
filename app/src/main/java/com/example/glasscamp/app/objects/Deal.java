package com.example.glasscamp.app.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Deal implements Parcelable
{

    private Date date;
    private String shop;
    private double amount;

    public Deal(double amount, String shop) {
        date = new Date();
        this.shop = shop;
        this.amount = amount;
    }

    public Deal(double amount, String shop, Date date) {
        this.date = date;
        this.shop = shop;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString()
    {
        String format = "dd/MM";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.FRANCE);
        return sdf.format(date);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Deal createFromParcel(Parcel in ) {
            return new Deal(in.readDouble(), in.readString());
        }

        public Balance[] newArray(int size) {
            return new Balance[size];
        }
    };


    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public double getAmount() {
        return Math.round(100);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeDouble(amount);
        dest.writeString(shop);
    }
}
