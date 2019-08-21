package com.spdb.training.socket.server;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

import com.spdb.training.beans.order.Order;
import com.spdb.training.beans.stock.Stock;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;

/**
* @ClassName: ClientThread
* @Description: TODO:
* @author Robin
* @date 2019年8月21日
*
*/

public class ClientThread implements Callable<String>{
	private final static ILog LOG = LoggerFactory.getLogger(SocketClient.class);
	private ArrayList<Stock> list = null;
	private Random random;
	
	public ClientThread(ArrayList<Stock> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		random = new Random();
	}

	@Override
	public String call() throws Exception {
		int i = random.nextInt(10);
		int qty = this.list.get(i).getQty();
		if(qty > 0) {
			qty--;
			this.list.get(i).setQty(qty);
			String xmlToString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><reqService><reqHeader><tranCode>OR02</tranCode><transDate>20190619</transDate><transTime>131452</transTime></reqHeader><body><itemCode>123</itemCode><qty>1</qty><orderUser>b</orderUser></body></reqService>";
			LOG.debug("xml:{}",xmlToString);
			// 2,按照6位长度+报文 规范生成新的请求报文
			int srcLength = xmlToString.getBytes("utf8").length;
			String newxml = String.format("%6d", srcLength).replace(" ", "0") + xmlToString;
			LOG.debug("newxml:{}",newxml);
			return newxml;
		}
		return null;
	}

}
