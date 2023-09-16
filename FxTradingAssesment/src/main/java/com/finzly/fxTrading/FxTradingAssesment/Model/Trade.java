package com.finzly.fxTrading.FxTradingAssesment.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeId;
	private String customerName;
	@OneToOne(cascade = CascadeType.ALL)
	private Currencypair currencyPair_id;
	private double transferAmount;
	private double amount;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Currencypair getCurrencyPair_id() {
		return currencyPair_id;
	}

	public void setCurrencyPair_id(Currencypair currencyPair_id) {
		this.currencyPair_id = currencyPair_id;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Trade(String customerName, Currencypair currencyPair_id, double amount) {
		this.customerName = customerName;
		this.currencyPair_id = currencyPair_id;
		this.amount = amount;
	}

	public Trade() {
	}

}
