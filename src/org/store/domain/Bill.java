package org.store.domain;

import java.util.List;

public class Bill {
    private int bId;
    private int custId;
    private List<Item> items;
    private double disRate;
    private double grossPay;
    private double discount;
    private double netPay;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public double getDisRate() {
        return disRate;
    }

    public void setDisRate(double disRate) {
        this.disRate = disRate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bId=" + bId +
                ", custId=" + custId +
                ", items=" + items +
                ", disRate=" + disRate +
                ", grossPay=$" + grossPay +
                ", discount=$" + discount +
                ", netPay=$" + netPay +
                '}';
    }
}

