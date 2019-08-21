package com.spdb.training.beans.order;

/**
 * 
 * @author 	ai12345
 * TODO		订单类，描述订单信息
 *
 */
public class Order {
	private static final long serialVersionUID = -1017085371735723853L;
	
	private Integer orderId;//订单号码
	private String itemCode;//商品代码
	private Integer qty;//订单数量
	private String orderDate;//订单日期
	private String orderTime;//订单时间
	private String orderUser;//下单人
	
	public Integer getOrderId() {//获取属性值
		return orderId;
	}
	public void setOrderId(Integer orderId) {//设定属性值
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
