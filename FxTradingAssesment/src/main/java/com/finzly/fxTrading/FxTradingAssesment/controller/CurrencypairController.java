package com.finzly.fxTrading.FxTradingAssesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Service.CurrencypairService;

@RestController
//@RequestMapping("currencypair")

public class CurrencypairController {
@Autowired
CurrencypairService service;

@GetMapping("getcurrency")
public List<Currencypair> getCurrencyPair()
{
	System.out.println("hello");
	return service. getCurrencyPair();
}
}
