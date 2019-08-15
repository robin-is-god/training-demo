package com.spdb.training.socket.trans.or02;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月19日 上午10:20:56 
*   类说明:
*/
@XmlType(propOrder= {"itemId", "qty", "orderUser"})
public class ReqOR02ServiceBody {
	@XmlElement(name="itemId")
	private String itemId;
	@XmlElement(name="qty")
	private int qty;
	@XmlElement(name="orderUser")
	private String orderUser;
	
	@XmlTransient
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@XmlTransient
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@XmlTransient
	public String getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}
}
