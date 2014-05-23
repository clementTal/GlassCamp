package com.example.glasscamp.app;

public class Balance {

    private float realBalance;
    private float estimatedBalance;

    public Balance() {
        realBalance = 0.f;
        estimatedBalance = 0.f;
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
}
