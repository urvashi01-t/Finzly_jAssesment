package fx_trading;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TradeOperations  {
	private int trade_number;
	private String currency_pair;
	private String customer_name;
	private double amount;
	private final static double rate=66.00;
	

	public int getTrade_number() {
		return trade_number;
		
	}

	public TradeOperations(String currency_pair, String customer_name, double amount) {
	super();
	this.currency_pair = currency_pair;
	this.customer_name = customer_name;
	this.amount = amount;
}

	public void setTrade_number(int trade_number) {
		this.trade_number = trade_number;
	}

	public String getCurrency_pair() {
		return currency_pair;
	}

	public void setCurrency_pair(String currency_pair) {
		this.currency_pair = currency_pair;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		if(isValidName(customer_name)) {
		this.customer_name = customer_name;
	}else {
		System.out.println("Please enter a valid name");
		//setCustomerName(scanner.nextLine());
	}
	}
	//Method for validating customer name
		private static boolean isValidName(String customerName) {
			return customerName.matches("^[a-zA-Z. ]+$");
		}

	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public static double getRate() {
		return rate;
	}
	public static ArrayList<TradeOperations> trades = new ArrayList<>();

	public void bookTrade() {
		//trades.add(trades);
		System.out.println("Trade booked successfully!");
		
	}
	
	public static void printTrades(List<TradeOperations> trades) {
        System.out.println("TradeNo CurrencyPair CustomerName Amount   Rate");
        for (int i = 0; i < trades.size(); i++) {
            TradeOperations trade = trades.get(i);
            System.out.printf("%-8d %-12s %-12s %-10s %.2f%n",
                    i + 1, trade.getCurrency_pair(), trade.getCustomer_name(),
                    "INR" + String.format("%.2f", trade.getAmount()), TradeOperations.getRate());
        }
    }
	



	}



