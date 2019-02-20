package com.kprsimulation.kprsimulatorbe.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public class KPRAttributes {

    @Id
    private int tenor;
    private double harga;
    private double dp;
    private double bunga;


    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getDp() {
        return dp;
    }

    public void setDp(double dp) {
        this.dp = dp;
    }

    public double getBunga() {
        return bunga;
    }

    public void setBunga(double bunga) {
        this.bunga = bunga;
    }
}
