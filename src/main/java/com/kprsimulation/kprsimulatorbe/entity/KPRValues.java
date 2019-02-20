package com.kprsimulation.kprsimulatorbe.entity;

import org.json.simple.JSONObject;

import java.text.DecimalFormat;
import java.util.List;
import java.text.DecimalFormatSymbols;

public class KPRValues {

    // Basic variables
    private double harga;
    private double dp; // persen

    // After setting basic variables
    private double totalPokok;
    private double bunga; // persen
    private double bungaDibayar;
    private int tenor;

    // Displayed variables
    private double saldoAwal;
    private double pokok;
    private double totalDibayar;
    private double saldoAkhir;

    private DecimalFormat idrCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    private DecimalFormatSymbols formatIDR = new DecimalFormatSymbols();

    public KPRValues(){}

    public KPRValues(double _harga, double _dp, double _bunga, int _tenor) {
        harga   = _harga;
        dp      = _dp;
        bunga   = _bunga;
        tenor   = _tenor;

        formatIDR.setCurrencySymbol("Rp. ");
        formatIDR.setMonetaryDecimalSeparator(',');
        formatIDR.setGroupingSeparator('.');

        idrCurrency.setDecimalFormatSymbols(formatIDR);
    }

    public void SetAllVariables() {

        dp              = harga * (dp / 100);
        totalPokok      = harga - dp;
        tenor           = tenor * 12;
        bunga           = (bunga / 100) / 12;
        bungaDibayar    = totalPokok * bunga;
        saldoAwal       = totalPokok;
        pokok           = totalPokok / tenor;
        totalDibayar    = pokok + bungaDibayar;
        saldoAkhir      = saldoAwal;
    }

    public List<JSONObject> Calculate(List<JSONObject> jsonObjectList)
    {
         for (int i = 0; i <= tenor; i++)
        {
            JSONObject json = new JSONObject();

            json.put("bulan", i);
            json.put("saldoAwal", idrCurrency.format(saldoAwal));
            json.put("pokok", idrCurrency.format(pokok));
            json.put("bunga", idrCurrency.format(bungaDibayar));
            json.put("totalDibayar", idrCurrency.format(totalDibayar));
            json.put("saldoAkhir", idrCurrency.format(saldoAkhir));

            //System.out.println("JSON KPR Object: " + json);

            jsonObjectList.add(json);
            saldoAkhir -= pokok;
            saldoAwal = saldoAkhir;
        }

        return jsonObjectList;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setDp(double dp) {
        this.dp = dp;
    }

    public void setTotalPokok(double totalPokok) {
        this.totalPokok = totalPokok;
    }

    public void setBunga(double bunga) {
        this.bunga = bunga;
    }

    public void setBungaDibayar(double bungaDibayar) {
        this.bungaDibayar = bungaDibayar;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public void setSaldoAwal(double saldoAwal) {
        this.saldoAwal = saldoAwal;
    }

    public void setPokok(double pokok) {
        this.pokok = pokok;
    }

    public void setTotalDibayar(double totalDibayar) {
        this.totalDibayar = totalDibayar;
    }

    public void setSaldoAkhir(double saldoAkhir) {
        this.saldoAkhir = saldoAkhir;
    }

    public double getDp() {
        return dp;
    }

    public double getTotalPokok() {
        return totalPokok;
    }

    public double getBunga() {
        return bunga;
    }

    public double getBungaDibayar() {
        return bungaDibayar;
    }

    public int getTenor() {
        return tenor;
    }

    public double getSaldoAwal() {
        return saldoAwal;
    }

    public double getPokok() {
        return pokok;
    }

    public double getTotalDibayar() {
        return totalDibayar;
    }

    public double getSaldoAkhir() {
        return saldoAkhir;
    }
}
