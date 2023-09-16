package com.finzly.fxTrading.FxTradingAssesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.FxTradingAssesment.Model.Trade;
import com.finzly.fxTrading.FxTradingAssesment.Service.TradeService;

@RestController
@RequestMapping("trade")

public class TradeController {
	 private final TradeService tradeService;

	    @Autowired
	    public TradeController(TradeService tradeService) {
	        this.tradeService = tradeService;
	    }

	    @GetMapping("booked")
	    public List<Trade> getAllBookedTrades() {
	        return tradeService.getAllBookedTrades();
	    }
	    @PostMapping("save")
	    public String getBookTrade(@RequestBody Trade trade) {
	    	return tradeService.bookTrade(trade);
	    }
//	    public ResponseEntity<String> bookTrade(@Validated @RequestBody Trade trade) {
//	        String validationErrors = validateTrade(trade);
//	        if (validationErrors != null) {
//	            return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
//	        }
//
//	        String result = tradeService.getBookTrade(trade);
//	        return new ResponseEntity<>(result, HttpStatus.CREATED);
//	    }
//
//	    private String validateTrade(Trade trade) {
//	        // Perform custom validation logic if needed
//	        if (trade == null) {
//	            return "Trade object is required.";
//	        }
//
//	        // Example validation: Ensure trade amount is positive
//	        if (trade.getAmount() <= 0) {
//	            return "Trade amount must be greater than zero.";
//	        }
//
//	       
//
//	        return null; // No validation errors
//	    }
	        
}
