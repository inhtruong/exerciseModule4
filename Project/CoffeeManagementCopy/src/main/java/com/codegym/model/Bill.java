package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private int id;
    private int numberTable;
    private String floor;
    private long subPrice;
    private long fee;
    private double totalBill;

    public Bill() {

    }

    public Bill(int id, int numberTable, String floor, long subPrice, long fee, long totalBill) {
        this.id = id;
        this.numberTable = numberTable;
        this.floor = floor;
        this.subPrice = subPrice;
        this.fee = fee;
        this.totalBill = totalBill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberTable() {
        return numberTable;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public long getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(long subPrice) {
        this.subPrice = subPrice;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public   Bill clone() throws CloneNotSupportedException {
        Bill clone = (Bill) super.clone();
        Bill bill = new Bill();
        bill.setId(id);
        bill.setNumberTable(numberTable);
        bill.setFloor(floor);
        bill.setSubPrice(subPrice);
        bill.setFee(fee);
        bill.setTotalBill(totalBill);
        return bill;
    }
}
