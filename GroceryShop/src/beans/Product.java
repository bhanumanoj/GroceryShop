package beans;

public class Product {
	private int productId;
	private String productName;
	private int quantity;
	private double ratePerQuantity;
	private ProductType productType;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRatePerQuantity() {
		return ratePerQuantity;
	}
	public void setRatePerQuantity(double ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", ratePerQuantity=" + ratePerQuantity + ", productType=" + productType + "]";
	}
	
	
}
