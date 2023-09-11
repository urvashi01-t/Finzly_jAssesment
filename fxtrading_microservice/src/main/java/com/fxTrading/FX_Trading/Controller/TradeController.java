package com.springboot.FXTrading.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.FXTrading.model.Trade;
import com.springboot.FXTrading.service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {
    @Autowired
    TradeService service;

    // Endpoint for booking a trade
    @PostMapping("book")
    public ResponseEntity<Object> bookTrade(@RequestBody Trade trade) {
        try {
            boolean isAdded = service.bookTrade(trade);
            if (isAdded) {
                String response = "Trade for " + trade.getCurrencyPair() + " has been booked with rate " + trade.getRate()
                        + ". The amount of Rs " + formatAmount(trade.getAmount() * trade.getRate())
                        + " will be transferred in 2 working days to " + trade.getCustomerName() + ".";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                String response = "Trade not booked. Kindly enter the details properly\n"
                        + "Follow the following rules while entering details:\n"
                        + "1. Currency pair must be USDINR \n"
                        + "2. Amount can't be zero or negative and can't exceed the trading limit";
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (IllegalArgumentException e) {
            // Handle validation exceptions and return a Bad Request response with the exception message
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Helper method to format the trade amount
    private String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##,##,##,##,##,##,##,##,##,###.00");
        return "INR " + df.format(amount);
    }

    // Endpoint for listing all trades
    @GetMapping("list")
    public ResponseEntity<Object> getAllTrades() {
        try {
            List<Trade> list = service.getAllTrade();
            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            // Handle exceptions during trade retrieval and return an Internal Server Error response
            return new ResponseEntity<>("An error occurred while retrieving trades.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
