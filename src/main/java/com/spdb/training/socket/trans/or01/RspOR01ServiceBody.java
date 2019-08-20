package com.spdb.training.socket.trans.or01;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.spdb.training.beans.stock.Stock;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月19日 上午10:20:56 
*   类说明:
*/
@XmlType(propOrder= {"nums","row"})
public class RspOR01ServiceBody {

	@XmlElement(name="nums")
	private int nums;
	@XmlElement(name="row")
	private List<Stock> row;
	
	@XmlTransient
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	@XmlTransient
	public List<Stock> getRow() {
		return row;
	}
	public void setRow(List<Stock> row) {
		this.row = row;
	}
}
