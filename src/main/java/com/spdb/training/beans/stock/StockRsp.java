package com.spdb.training.beans.stock;

import java.io.Serializable;
import java.util.List;

/**
* @ClassName: StockRsp
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public class StockRsp implements Serializable {
	private static final long serialVersionUID = -1017085371735723853L;
	
	private int num;
	
	private List<Stock> row;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Stock> getRow() {
		return row;
	}

	public void setRow(List<Stock> row) {
		this.row = row;
	}
}
