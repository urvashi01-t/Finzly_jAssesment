package com.springboot.FXTrading.model;

public class Trade {
    private static final double TRADING_AMOUNT_LIMIT = 1.7976931348623157E+308;
    private int tradeID;
    private String customerName;
    private String currencyPair;
    private double rate;
    private double amount;
    private boolean tradeConfirmed = false;

    public Trade() {

    }

    /**
     * Creates a new Trade object.
     *
     * @param customerName Customer's name.
     * @param currencyPair Currency pair (e.g., USD/EUR).
     * @param rate         Exchange rate for the trade.
     * @param amount       Amount to trade.
     * @throws IllegalArgumentException if the rate or amount is non-positive.
     */
    public Trade(String customerName, String currencyPair, double rate, double amount) {
        if (rate <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Rate and amount must be positive.");
        }
        this.customerName = customerName;
        this.currencyPair = currencyPair;
        this.rate = rate;
        this.amount = amount;
        this.tradeConfirmed = true;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Rate must be positive.");
        }
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.amount = amount;
    }

    public boolean isTradeConfirmed() {
        return tradeConfirmed;
    }

    public void setTradeConfirmed(boolean tradeConfirmed) {
        this.tradeConfirmed = tradeConfirmed;
    }

    public static double getTradingAmountLimit() {
        return TRADING_AMOUNT_LIMIT;
    }
}
