package com.finzly.fxTrading.FxTradingAssesment.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Model.Trade;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
@Repository
public class TradeDao {
	
 @Autowired
SessionFactory factory;

//@Transactional
//public Trade save(Trade trade) {
//  
//}

public List<Trade> getAllTrades() {
	 Session session = factory.openSession();
	Criteria criteria = session.createCriteria(Trade.class);

	return criteria.list();
}
//public String getBookTrade(Trade trade) {
//	Session session = factory.openSession();
//	session.save(trade);
//	session.beginTransaction().commit();
//	return "Done";
//}
public String bookTrade(Trade trade) {
	Session session = factory.openSession();
	session.save(trade);
	return "Trade Booked Tiwari";
}
}
