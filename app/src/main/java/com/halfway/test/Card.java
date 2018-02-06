package com.halfway.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Card {
    @SerializedName("stock")
    @Expose
    private List<Stock> stock = null;
    @SerializedName("as_of")
    @Expose
    private String asOf;

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public String getAsOf() {
        return asOf;
    }

    public void setAsOf(String asOf) {
        this.asOf = asOf;
    }

    public class Price {

        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("amount")
        @Expose
        private double amount;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public class Stock {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private Price price;
        @SerializedName("percent_change")
        @Expose
        private double percentChange;
        @SerializedName("volume")
        @Expose
        private int volume;
        @SerializedName("symbol")
        @Expose
        private String symbol;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public double getPercentChange() {
            return percentChange;
        }

        public void setPercentChange(double percentChange) {
            this.percentChange = percentChange;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

    }

}
