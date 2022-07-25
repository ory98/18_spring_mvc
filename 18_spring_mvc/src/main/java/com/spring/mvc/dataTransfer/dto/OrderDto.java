package com.spring.mvc.dataTransfer.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class OrderDto {
	
	private String orderCode;
	private String memberId;
	private String productCode;
	private int orderGoodsQty;
	private String deliveryMessage;
	private String deliveryState;
	private Date orderDate;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getOrderGoodsQty() {
		return orderGoodsQty;
	}
	public void setOrderGoodsQty(int orderGoodsQty) {
		this.orderGoodsQty = orderGoodsQty;
	}
	public String getDeliveryMessage() {
		return deliveryMessage;
	}
	public void setDeliveryMessage(String deliveryMessage) {
		this.deliveryMessage = deliveryMessage;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderDto [orderCode=" + orderCode + ", memberId=" + memberId + ", productCode=" + productCode
				+ ", orderGoodsQty=" + orderGoodsQty + ", deliveryMessage=" + deliveryMessage + ", deliveryState="
				+ deliveryState + ", orderDate=" + orderDate + "]";
	}
	
	
}
