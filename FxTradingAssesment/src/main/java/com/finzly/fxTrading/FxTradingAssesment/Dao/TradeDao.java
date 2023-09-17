package com.finzly.fxTrading.FxTradingAssesment.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Model.Trade;
import com.finzly.fxTrading.FxTradingAssesment.Service.CurrencypairService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class TradeDao {
	// Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairService.class);

	@Autowired
	SessionFactory factory;
//Commented out method without implementation, consider removing it
	// @Transactional
	// public Trade save(Trade trade) {
	// }

	// Retrieve a list of all trades from the database
	public List<Trade> getAllTrades() {
		logger.info("Fetching all booked trades from data base(TradeDao)");
		// Open a session to interact with the database
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		// Return the list of trades
		return criteria.list();
	}

//Book a trade by adding it to the database
	public String bookTrade(Trade trade) {
		logger.info("Adding trade data into data base(TradeDao)");
		// Open a session to interact with the database

		Session session = factory.openSession();
		// Save the trade to the database

		session.save(trade);
		// Return a success message

		return "Trade Booked ";
	}
}
