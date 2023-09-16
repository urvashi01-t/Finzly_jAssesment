package com.finzly.fxTrading.FxTradingAssesment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.FxTradingAssesment.Dao.CurrencypairDao;
import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;

@Service
public class CurrencypairService {
	@Autowired
CurrencypairDao dao;

public List<Currencypair> getCurrencyPair() {
	System.out.println("it works");
	return dao.getCurrencyPair();
}
}
