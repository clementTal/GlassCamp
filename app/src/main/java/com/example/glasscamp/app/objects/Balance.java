package com.example.glasscamp.app.objects;

import java.util.ArrayList;
import java.util.List;

public class Balance {

    private float realBalance;
    private float estimatedBalance;
    private ArrayList<Deal> deals;

    public Balance() {
        realBalance = 0.f;
        estimatedBalance = 0.f;
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

    public List<Deal> getDeals() {
        return deals;
    }
}
