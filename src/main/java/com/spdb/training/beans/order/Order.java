package com.spdb.training.beans.order;

import java.io.Serializable;

/**
 * 
 * @author 	ai12345
 * TODO		订单类，描述订单信息
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = -1017085371735723853L;
	
	private Integer orderId;//订单号码
	private String orderCode;//商品代码
	private Integer orderNum;//订单数量
	private String orderDate;//订单日期
	private String orderTime;//订单时间
	private String orderUser;//下单人
	
	
	
	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getOrderCode() {
		return orderCode;
	}



	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}



	public Integer getOrderNum() {
		return orderNum;
	}



	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}



	public String getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	public String getOrderTime() {
		return orderTime;
	}



	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}



	public String getOrderUser() {
		return orderUser;
	}



	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCode=" + orderCode + ", orderNum=" + orderNum + ", orderDate=" + orderDate
				+ ", orderTime=" + orderTime + ", orderUser=" + orderUser + "]";
	}
}
