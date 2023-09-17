package com.finzly.fxTrading.FxTradingAssesment.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.FxTradingAssesment.Dao.CurrencypairDao;
import com.finzly.fxTrading.FxTradingAssesment.Dao.TradeDao;
import com.finzly.fxTrading.FxTradingAssesment.Exception.IdNotAvailableException;
import com.finzly.fxTrading.FxTradingAssesment.Exception.TradeNotAvailableException;
import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Model.Trade;

@Service
public class TradeService {
	// Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairService.class);

	@Autowired

	TradeDao tradeDao;
	@Autowired
	CurrencypairDao currencypairDao;

//@Author: // Book a trade by adding it to the database
	public String bookTrade(Trade trade) {
		logger.info("Adding trade data into data base(TradeService)");
		// Validate the trade before booking
		validateTrade(trade);
		// Book the trade using the TradeDao
		return tradeDao.bookTrade(trade);
	}

	// Validate the trade data
	private void validateTrade(Trade trade) {
		logger.info("Fetching all booked trades from data base(TradeService)");

		// Validate the customer name
		if (trade.getCustomerName() == null || trade.getCustomerName().isEmpty()) {
			throw new IllegalArgumentException("Customer name cannot be empty.");
		}
		if (trade.getTradeId() == 0) {
			throw new IdNotAvailableException("requested Trade are not available");
		}

		// Validate the amount
		if (trade.getAmount() <= 0) {
			throw new IllegalArgumentException("Trade amount must be greater than zero.");
		}

	}
//@Author : // Get a list of all booked trades

	public List<Trade> getAllBookedTrades() {
		if (tradeDao.getAllTrades().isEmpty()) {
			// Check if any trades are available; if not, throw an exception
			throw new TradeNotAvailableException();
		}
		// Return the list of booked trades
		return tradeDao.getAllTrades();
	}

}
