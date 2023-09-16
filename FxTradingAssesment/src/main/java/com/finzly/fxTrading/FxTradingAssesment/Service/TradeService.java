package com.finzly.fxTrading.FxTradingAssesment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.FxTradingAssesment.Dao.CurrencypairDao;
import com.finzly.fxTrading.FxTradingAssesment.Dao.TradeDao;
import com.finzly.fxTrading.FxTradingAssesment.Model.Currencypair;
import com.finzly.fxTrading.FxTradingAssesment.Model.Trade;

@Service
public class TradeService {
	
	 @Autowired
	    
	 TradeDao tradeDao;
@Autowired
CurrencypairDao currencypairDao;

	public String bookTrade(Trade trade) {
		  validateTrade(trade);

		return tradeDao.bookTrade(trade);
    }
	private void validateTrade(Trade trade) {
        // Validate the customer name
        if (trade.getCustomerName() == null || trade.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }

        // Validate the amount
        if (trade.getAmount() <= 0) {
            throw new IllegalArgumentException("Trade amount must be greater than zero.");
        }

       
    }

//	public List<Trade> getAllBookedTrades() {
//		return tradeDao.getAllTrades();
//	}
		public List<Trade> getAllBookedTrades() {
			return tradeDao.getAllTrades();
		}

//		public String getBookTrade(Trade trade) {
//			List<Currencypair> trader = currencypairDao.getCurrencyPair();
//			for (Currencypair tradi : trader) {
//				if (tradi.getCurrencypairId() == trade.getCurrencyPair_id().getCurrencypairId()){
//					//trade.setTransferAmount(tradi.getRate() * trade.getAmount());
//					break;
//				}
//			}
//		
//			return tradeDao.getBookTrade(trade);
//		}


}
