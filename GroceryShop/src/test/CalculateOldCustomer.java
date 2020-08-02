package test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import beans.Product;
import beans.ProductType;
import beans.User;
import beans.UserType;
import service.RetailWebsite;
import service.RetailWebsiteImpl;

public class CalculateOldCustomer {
	
	@Test
	void test() {
		RetailWebsite retail=new RetailWebsiteImpl();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		user.setUserId(2);
		user.setUserName("srikanth");
		user.setUsertype(UserType.CUSTOMER);
		LocalDate date = LocalDate.parse("2015-07-28");
		user.setRegistrationDate(date);
		product.setProductId(50);
		product.setProductName("potato");
		product.setProductType(ProductType.GROCERIES);
		product.setQuantity(10);
		product.setRatePerQuantity(10);
		list.add(product);
		product1.setProductId(100);
		product1.setProductName("wool");
		product1.setProductType(ProductType.CLOTHING);
		product1.setQuantity(10);
		product1.setRatePerQuantity(20);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(280,bill);
}
}