package com.spdb.training.beans.order;
/**
 * @ClassName:Order
 * @Description: TODO:
 * @author annliao
 * @date 2019年8月16日
 *
 */
public class Order {
	private static final long serialVersionUID = -1017085371735723853L;
	
	private String orderId;//订单号码
	private String itemCode;//商品代码
	private Integer qty;//订单数量
	private String orderDate;//订单日期
	private String orderTime;//订单时间
	private String orderUser;//下单人
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
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
	
	
	
}
