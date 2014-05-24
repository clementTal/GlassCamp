package com.example.glasscamp.app.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Random;

public class Balance implements Parcelable
{

    private float realBalance;
    private float estimatedBalance;
    private ArrayList<Deal> deals;

    public Balance(float realBalance, float estimatedBalance) {
        this.realBalance = realBalance;
        this.estimatedBalance = estimatedBalance;
        deals = new ArrayList<Deal>();
    }

    public Balance getBalance()
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
