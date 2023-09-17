package com.finzly.fxTrading.FxTradingAssesment.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.FxTradingAssesment.Dao.CurrencypairDao;
import com.finzly.fxTrading.FxTradingAssesment.Exception.CurrencypairNotAvailableException;
import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;

@Service
public class CurrencypairService {
	  // Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairService.class);

	@Autowired
CurrencypairDao dao;
	// Retrieve a list of currency pairs from the database
public List<Currencypair> getCurrencyPair() {
	logger.info("Fetching all currency pair from data base (CurrencypairService)");
    // Check if any currency pairs are available; if not, throw an exception

	if( dao.getCurrencyPair().isEmpty() ) {
		throw new CurrencypairNotAvailableException("Requested Currency Pair is not available");
	}
	else
		return  dao.getCurrencyPair();
	
}
}
