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

public class CalculateCustomer {
	
	@Test
	void test() {
		RetailWebsite retail=new RetailWebsiteImpl();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		user.setUserId(2);
		user.setUserName("sairam");
		user.setUsertype(UserType.CUSTOMER);
		user.setRegistrationDate(LocalDate.now());
		product.setProductId(50);
		product.setProductName("tomato");
		product.setProductType(ProductType.GROCERIES);
		product.setQuantity(10);
		product.setRatePerQuantity(10);
		list.add(product);
		product1.setProductId(100);
		product1.setProductName("cotton");
		product1.setProductType(ProductType.CLOTHING);
		product1.setQuantity(10);
		product1.setRatePerQuantity(10);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(190, bill);
}
}