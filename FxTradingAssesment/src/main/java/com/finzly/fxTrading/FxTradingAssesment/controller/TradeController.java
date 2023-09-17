package com.finzly.fxTrading.FxTradingAssesment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.finzly.fxTrading.FxTradingAssesment.Service.CurrencypairService;
import com.finzly.fxTrading.FxTradingAssesment.Service.TradeService;

@RestController
@RequestMapping("trade")

public class TradeController {
	 // Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairService.class);

	 private final TradeService tradeService;

	    @Autowired
	   // @Author: Urvashi Tiwari :
		// @Author: Urvashi Tiwari : constructor of Trade Controller

	    public TradeController(TradeService tradeService) {
	    	
	        this.tradeService = tradeService;
	    }
	 // @Author: Urvashi Tiwari : API for fetching all the booked trades from the database by the user
	    @GetMapping("booked")
	    public List<Trade> getAllBookedTrades() {
			logger.info("Adding Trade data into data base(TradeController)");

	        return tradeService.getAllBookedTrades();
	    }
	 // @Author: Urvashi Tiwari : API for users to book a trade and store it in the database
	    @PostMapping("save")
	    public String getBookTrade(@RequestBody Trade trade) {
			logger.info("Fetching all booked trades from data base(TradeController)");

	    	return tradeService.bookTrade(trade);
	    }

	        
}
