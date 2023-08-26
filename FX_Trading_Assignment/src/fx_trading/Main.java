package fx_trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {
	  private static boolean containsOnlyLetters(String input) {
	        return input.matches("[a-zA-Z]+");
	    }
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("enter your action 1 for book trade 2 print trade and 3 for exit");
			
			 List<TradeOperations> trades= new ArrayList<>();
			 
			while(true) {
				switch(scanner.nextInt()) {
				case 1:
//				System.out.println("BOOK TRADE");
					scanner.nextLine();
				 System.out.println("Book trade");

                String name = "";
                 while (name.isEmpty() || !containsOnlyLetters(name)) {
                     System.out.println("Enter your name");
                     name = scanner.nextLine();

                     if (name.isEmpty() || !containsOnlyLetters(name)) {
                         System.err.println("Invalid name. Please enter a valid name with only letters.");
                     }
                 }

			   //  System.out.println("Enter Currency Pair");
		     String currencyPair ;
		     do {
			    	    System.out.println("Enter Currency Pair (Only USDINR is supported)");
			    	    currencyPair = scanner.nextLine();
			    	    if (!currencyPair.equalsIgnoreCase("USDINR")) {
			    	        System.err.println("Invalid currency pair! Only USDINR is supported. Please try again.");
			    	    }
			    	} while (!currencyPair.equalsIgnoreCase("USDINR"));
			     
//			     System.out.println("Enter amount to transfer");
////			     double amount = scanner.nextDouble();
//			     double amount = -1;
//                 try {
//                     amount = scanner.nextDouble();
//                 } catch (Exception e) {
//                     System.err.println("Invalid amount format. Please enter a valid number.");
//                     scanner.nextLine(); // Clear the input buffer
//                     break;
//                 }
		     double amount = -1;
             while (amount < 0) {
                 System.out.println("Enter amount to transfer");
                 try {
                     amount = scanner.nextDouble();
                     if (amount < 0) {
                         System.err.println("Amount cannot be negative.");
                     }
                 } catch (Exception e) {
                     System.err.println("Invalid amount format. Please enter a valid number.");
                     scanner.nextLine(); // Clear the input buffer
                 }
             }


			     scanner.nextLine(); // Consume the newline
			     System.out.println("Do you want to get rate (yes/no)");
			     String check = scanner.nextLine();
			     TradeOperations trade = new TradeOperations(currencyPair, name, amount);
			     
			     if (check.equalsIgnoreCase("yes")) {
			         System.out.println("You are transferring " + trade.getAmount() + " to " +
			                 trade.getCustomer_name() + " with " + TradeOperations.getRate());
			     }
			     System.out.println("Do you want to (Book/Cancel)");
			     String check1 = scanner.nextLine();
			     
			     if (check1.equalsIgnoreCase("Book")) {
			    	 trades.add(trade);
			        System.out.println(
			        		"Trade for "+trade.getCurrency_pair()+" has been booked with rate"+ TradeOperations.getRate() +", The amount of" +" "+ trade.getAmount()+" will  be transferred in 2 working days to "+trade.getCustomer_name() );
			     } else if(check1.equalsIgnoreCase("Cancel")){
			    	 System.out.println("Trade is Canceled. ");
			  		System.out.println("enter your action 1 for book trade 2 print trade and 3 for exit");

			     }
			     break;
				case 2:
			        TradeOperations.printTrades(trades);
					break;
				
				case 3: 
					scanner.nextLine();
					System.out.println("Do you want to exit (yes/no)");
			         String check2 = scanner.nextLine();
			         
			         if(check2.equalsIgnoreCase("yes")) {
			        	 System.out.println("Bye - have a good day");
			         }else {
			        	 System.out.println("try again");
			       		System.out.println("enter your action 1 for book trade 2 print trade and 3 for exit");
			       		

			         }
			        break;

				
				}
				

			}
		}
		

	}
	  
}
