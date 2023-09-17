package com.finzly.fxTrading.FxTradingAssesment.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.controller.CurrencypairController;

@Repository
public class CurrencypairDao {
	// Create a logger for this class
	Logger logger = LoggerFactory.getLogger(CurrencypairDao.class);
	@Autowired
	SessionFactory factory;
	 // Retrieve a list of currency pairs from the database
	public List<Currencypair> getCurrencyPair() {
		logger.info("Fetching all currency pair from data base (CurrencypairDao)");
        // Open a session to interact with the database

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Currencypair.class);
        // Return the list of currency pairs

		return criteria.list();

	}

}
