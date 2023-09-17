package com.finzly.fxTrading.FxTradingAssesment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Service.CurrencypairService;

@RestController
@RequestMapping("currencypair")

public class CurrencypairController {
	// Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairController.class);
	@Autowired
	CurrencypairService service;

// Endpoint to get a list of currency pairs
	@GetMapping("getcurrency")
// @Author Urvashi Tiwari :API for fetching all the booked trades from the database by the user
	public List<Currencypair> getCurrencyPair() {
		logger.info("Fetching all currency pair from data base (CurrencypairController)");
		System.out.println("hello");
		// Call the service to retrieve the currency pairs and return them

		return service.getCurrencyPair();
	}
}
