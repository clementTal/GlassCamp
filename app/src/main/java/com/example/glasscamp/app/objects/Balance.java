package com.example.glasscamp.app.objects;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
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
