package com.finzly.fxTrading.FxTradingAssesment.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currencypair {

	private double currencypairId;
	private String currencypairName;
	private double rate;

	@Id
	public double getCurrencypairId() {
		return currencypairId;
	}

	public void setCurrencypairId(double currencypairId) {
		this.currencypairId = currencypairId;
	}

	public String getCurrencypairName() {
		return currencypairName;
	}

	public void setCurrencypairName(String currencypairName) {
		this.currencypairName = currencypairName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Currencypair [currencypairId=" + currencypairId + ", currencypairName=" + currencypairName + ", rate="
				+ rate + "]";
	}

}
