package com.springboot.FXTrading.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.FXTrading.model.Trade;

@Service
public class TradeService {

    private static int tradeCount = 0;
    List<Trade> list = new ArrayList<>();

    public boolean bookTrade(Trade trade) {
        try {
            // Introduce a NullPointerException by accessing a property of a null object
            String customerName = trade.getCustomerName();
            if (customerName.length() == 0) {
                throw new NullPointerException("Customer name is null.");
            }

            validateTrade(trade); // Perform validations

            tradeCount++;
            trade.setTradeID(tradeCount);
            trade.setTradeConfirmed(true);
            list.add(trade);
            return true;
        } catch (NullPointerException e) {
            // Handle NullPointerException here
            System.err.println("NullPointerException: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            // Handle validation exceptions here
            System.err.println("IllegalArgumentException: " + e.getMessage());
            return false;
        }
    }
//Storing the list of trades
    public List<Trade> getAllTrade() {
        return list;
    }

    // Custom validation method for Invalid currency pair,Invalid trade amount,Invalid trade rate
    
    private void validateTrade(Trade trade) {
        if (!trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
            throw new IllegalArgumentException("Invalid currency pair.");
        }

        if (trade.getAmount() <= 0 || trade.getAmount() > Trade.getTradingAmountLimit()) {
            throw new IllegalArgumentException("Invalid trade amount.");
        }

        if (trade.getRate() != 66) {
            throw new IllegalArgumentException("Invalid trade rate.");
        }
    }
}
