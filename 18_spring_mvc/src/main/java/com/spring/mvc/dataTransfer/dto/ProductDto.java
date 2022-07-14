package com.spring.mvc.dataTransfer.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDto {
	
	private String productCode;
	private String productName;
	private int productPrice;
	private int productDeliveryPrice;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductDeliveryPrice() {
		return productDeliveryPrice;
	}
	public void setProductDeliveryPrice(int productDeliveryPrice) {
		this.productDeliveryPrice = productDeliveryPrice;
	}
	@Override
	public String toString() {
		return "ProductDto [productCode=" + productCode + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productDeliveryPrice=" + productDeliveryPrice + "]";
	}
	
	
	
	
	
	

}
