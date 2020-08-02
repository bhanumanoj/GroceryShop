package service;

import java.time.LocalDate;

import beans.Product;
import beans.ProductType;
import beans.User;
import beans.UserType;

public class RetailWebsiteImpl implements RetailWebsite{

	@Override
	public double calculateBill(User user) {

		double discount=0.0,withoutGroceryTotal=0.0,groceryTotal=0.0,totalPrice=0.0;
		int commonDiscount=0;
		
		for(Product product:user.getProduct())
		{
			if(product.getProductType()==ProductType.GROCERIES)
			{
				groceryTotal=groceryTotal+(product.getQuantity()*product.getRatePerQuantity());
			}
			else
			{
				withoutGroceryTotal=withoutGroceryTotal+(product.getQuantity()*product.getRatePerQuantity());
			}
		}
		
		if(user.getUsertype()==UserType.EMPLOYEE) {
			discount=withoutGroceryTotal*0.30;
			totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
		}
		
		else if(user.getUsertype()==UserType.AFFILLIATE) {
			discount=withoutGroceryTotal*0.10;
			totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
		}
		
		else
		{
			int yearDifference=LocalDate.now().getYear()-user.getRegistrationDate().getYear();
			if(yearDifference>=2) {
				discount=withoutGroceryTotal*0.05;
				totalPrice=(groceryTotal+withoutGroceryTotal)-discount;
			}
			else {
				user.setRegistrationDate(LocalDate.now());
				totalPrice=(groceryTotal+withoutGroceryTotal);
			}
		}
		commonDiscount=(int)totalPrice;
		totalPrice=totalPrice-((commonDiscount/100)*5);
		return totalPrice;
		}
	}

