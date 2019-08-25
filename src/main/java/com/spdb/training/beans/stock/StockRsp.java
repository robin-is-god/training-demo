package com.spdb.training.beans.stock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @ClassName: StockRsp
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/
public class StockRsp implements Serializable {
	private static final long serialVersionUID = -1017085371735723853L;
	
	private int nums;
	
	private List<Stock> row;
	
	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public List<Stock> getRow() {
		return row;
	}

	public void setRow(List<Stock> row) {
		this.row = row;
	}
	
}
