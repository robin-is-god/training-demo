package com.spdb.training.socket.trans.or02;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月19日 上午10:20:56 
*   类说明:
*/
@XmlType(propOrder= {"orderCode", "orderNum", "orderUser"})
public class ReqOR02ServiceBody {
	@XmlElement(name="orderCode")
	private String orderCode;
	@XmlElement(name="orderNum")
	private Integer orderNum;
	@XmlElement(name="orderUser")
	private String orderUser;
	
	@XmlTransient
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	@XmlTransient
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	@XmlTransient
	public String getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}
	
}
