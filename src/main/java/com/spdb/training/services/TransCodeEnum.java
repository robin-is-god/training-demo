package com.spdb.training.services;
/**
 * ������ö��
 * @author wanglw2
 *
 */
public enum TransCodeEnum {
	OR01("OR01","商品库存查询"),
	OR02("OR02","商品购买");
	/**
	 * ���״���
	 */
	private String transCode;
	/**
	 * ��������
	 */
	private String transName;
	TransCodeEnum(String transCode,String transName){
		this.transCode = transCode;
		this.transName = transName;
	}
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	public String getTransCode() {
		return transCode;
	}
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
}
