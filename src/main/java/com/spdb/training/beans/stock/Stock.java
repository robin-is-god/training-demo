package com.spdb.training.beans.stock;

import java.io.Serializable;

/**
* @ClassName: Stock
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public class Stock implements Serializable {
	private static final long serialVersionUID = -1017085371735723853L;
	
	private String itemCode;
	
	private Integer qty;


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
	
}
