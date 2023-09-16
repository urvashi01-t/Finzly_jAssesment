package com.finzly.fxTrading.FxTradingAssesment.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;

@Repository
public class CurrencypairDao {
	@Autowired
	SessionFactory factory;

	public List<Currencypair> getCurrencyPair() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Currencypair.class);

		return criteria.list();

	}

}
