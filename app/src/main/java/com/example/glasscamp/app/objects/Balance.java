package com.example.glasscamp.app.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
public class Balance implements Parcelable
{

    private static  float realBalance;
    private static float estimatedBalance;
    private static ArrayList<Deal> deals;
    private static Balance balance;

    public Balance(float realBalance, float estimatedBalance) {
        this.realBalance = realBalance;
        this.estimatedBalance = estimatedBalance;
        deals = new ArrayList<Deal>();
        balance = this;
    }

    public Balance(float realBalance, float estimatedBalance, ArrayList<Deal> deals) {
        this.realBalance = realBalance;
        this.estimatedBalance = estimatedBalance;
        for (Deal deal : deals)
        {
            this.addDeal(deal);
        }
        balance = this;
    }

    public static Balance getInstance()
    {
        return balance;
    }


    public Balance getBallance()
    {
        return this;
    }

    public float getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(float realBalance) {
        this.realBalance = realBalance;
    }

    public float getEstimatedBalance() {
        return estimatedBalance;
    }

    public void setEstimatedBalance(float estimatedBalance) {
        this.estimatedBalance = estimatedBalance;
    }

    public void addDeal(Deal dealToAdd)
    {
        estimatedBalance = 1000.f;
        deals.add(dealToAdd);
        for (Deal deal : deals)
        {
            estimatedBalance -= deal.getAmount();
        }
    }

    public void addRandomDeal()
    {
        String shop;
        String shops[] = {"Carrefour", "Auchan", "Leclerc", "Intermarché", "Cora", "Super U"};
        int shopNumber = (int)(Math.random() * shops.length); // max : 6
        shop = shops[shopNumber];

        Deal deal = new Deal(20 + (float)(Math.random() * ((100 - 20) + 1)), shop); // min : 20€; max : 100€
        addDeal(deal);
    }

    public ArrayList<Deal> getDeals() {
        return deals;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Balance createFromParcel(Parcel in ) {
            return new Balance(in.readFloat(), in.readFloat(), in.readArrayList(Deal.class.getClassLoader()));
        }

        public Balance[] newArray(int size) {
            return new Balance[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeFloat(estimatedBalance);
        dest.writeFloat(realBalance);
        dest.writeList(deals);
    }
}
