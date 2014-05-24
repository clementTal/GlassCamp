package com.example.glasscamp.app.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Balance
{

    private  double realBalance;
    private double estimatedBalance;
    private ArrayList<Deal> deals;

    public Balance() {
        this.realBalance = 15000.0;
        this.estimatedBalance = 15000.0;
        Deal deal1 = new Deal(12.25,"Auchan");
        this.addDeal(deal1);
        Deal deal2 = new Deal(63.88,"Leclerc");
        this.addDeal(deal2);
        Deal deal3 = new Deal(32.25,"Opti");
        this.addDeal(deal3);
        Deal deal4 = new Deal(7.85,"Mac do");
        this.addDeal(deal4);
        Deal deal5 = new Deal(12.85,"Pizza");
        this.addDeal(deal5);
    }


    public double getRealBalance() {
        return Math.round(realBalance);
    }

    public void setRealBalance(double realBalance)
    {
        this.realBalance = realBalance;
    }

    public double getEstimatedBalance() {
        return Math.round(estimatedBalance);
    }

    public void setEstimatedBalance(double estimatedBalance) {
        this.estimatedBalance = estimatedBalance;
    }

    public void addDeal(Deal dealToAdd)
    {
        this.getDeals().add(dealToAdd);
        for (Deal deal : deals)
        {
            this.estimatedBalance= this.getEstimatedBalance() - deal.getAmount();
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
        if (deals == null)
        {
            deals = new ArrayList<Deal>();
        }
        return deals;
    }
}
