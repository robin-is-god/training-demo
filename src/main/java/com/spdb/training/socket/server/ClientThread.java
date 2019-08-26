package com.spdb.training.socket.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.utils.StringUtils;

/**
* @ClassName: ClientThread
* @Description: TODO:
* @author Robin
* @date 2019年8月21日
*
*/

public class ClientThread implements Callable<String>{
	private final static ILog LOG = LoggerFactory.getLogger(ClientThread.class);
	private final static String CHARSET_UTF8 = "utf8";
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_PORT = 8084;
	private List<Stock> list;
	private Random random;
	private SocketClient socketClient;
	public ClientThread(List<Stock> list) {
		random = new Random();
		this.list = list;
		socketClient = new SocketClient();
	}
	
	public static List<String> getQtyStockList(String stringXml) {
		String rgex = "<itemCode>(.*?)</itemCode>";
		List<String> list = new ArrayList<>();
		list = StringUtils.getStringXmlBody(stringXml, rgex);
		return list;
	}
	
	@Override
	public String call() throws Exception {
		//Random random = new Random();
		int i = random.nextInt(list.size());
		String orderXmlToString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><reqService><reqHeader><tranCode>OR02</tranCode><transDate>20190619</transDate><transTime>131452</transTime></reqHeader><body><orderCode>" + this.list.get(i).getItemCode() + "</orderCode><orderNum>1</orderNum><orderUser>" + Thread.currentThread().getName() + "</orderUser></body></reqService>";
		int orderXmlLength = orderXmlToString.getBytes("utf8").length;
		String newRrderXml = String.format("%6d", orderXmlLength).replace(" ", "0") + orderXmlToString;
		String rspXmlString = socketClient.start(newRrderXml,SERVER_IP,SERVER_PORT);
		return rspXmlString;
	}
}
