package com.spdb.training.socket.trans.or02;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月19日 上午10:20:56 
*   类说明:
*/
@XmlType(propOrder= {"nameId","transDate"})
public class RspOR02ServiceBody {

	@XmlElement(name="nameId")
	private String nameId;
	@XmlElement(name="transDate")
	private String transDate;
	
	@XmlTransient 
	public String getNameId() {
		return nameId;
	}
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	@XmlTransient 
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	
}
