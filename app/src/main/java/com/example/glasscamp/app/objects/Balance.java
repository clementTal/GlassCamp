package com.example.glasscamp.app.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Balance implements Serializable {

    private float realBalance;
    private float estimatedBalance;
    private ArrayList<Deal> deals;

    public Balance() {
        realBalance = 0.f;
        estimatedBalance = 0.f;
        deals = new ArrayList<Deal>();
    }

    public Balance(float realBalance, float estimatedBalance) {
        this.realBalance = realBalance;
        this.estimatedBalance = estimatedBalance;
        deals = new ArrayList<Deal>();
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

    public ArrayList<Deal> getDeals() {
        return deals;
    }
}
