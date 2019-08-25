package com.spdb.training.socket.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.socket.parsemsg.ParseXmlMessage;
import com.spdb.training.socket.trans.or01.RspOR01Service;
import com.spdb.training.socket.xml.ReflectParseUtils;
import com.spdb.training.utils.StringUtils;

public class SocketClient {

	private final static ILog LOG = LoggerFactory.getLogger(SocketClient.class);
	private final static String CHARSET_UTF8 = "utf8";
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_PORT = 8084;
	
	public String start(String request, String host, int port) {

		Socket socket = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;

		try {
			socket = new Socket(host, port); // 指定连接的服务端地址
			LOG.debug("Socket客户端已经启动，端口:{}",socket.getLocalPort());
			
			// 1,发送请求数据
			outputStream = socket.getOutputStream();
			outputStream.write(request.getBytes(CHARSET_UTF8));
			outputStream.flush();
			// 2,获取服务端的返回信息
			inputStream = socket.getInputStream();
			// 3,根据规则，拿到只有报文的返回报文
			byte[] body = new ParseXmlMessage().readMsgByLength(inputStream, 6);
			String rspXML = new String(body, CHARSET_UTF8);
			LOG.debug("客户端收到的应答报文:{}", rspXML);
			return rspXML;
		} catch (Exception e) {
			LOG.error("客户端与服务端交互时抛出异常",e);
			return null;
		} finally {
			try {
				if (inputStream != null) outputStream.close();
				if (outputStream != null) outputStream.close();
				if (socket != null) socket.close();
			} catch (Exception e2) {
				LOG.error("客户端流关闭时抛出异常",e2);
			}
		}
	}
	
	public static List<String> getQtyStockList(String stringXml) {
		String rgex = "<itemCode>(.*?)</itemCode>";
		List<String> list = new ArrayList<>();
		list = StringUtils.getStringXmlBody(stringXml, rgex);
		return list;
	}
	
	public static void main(String[] args) throws Throwable, Throwable {
		//Socket报文交易方式
		//main采用的Dao->Service.相关包->Service里面相关TranService->Service.TransServiceFactory->TransCoreService2
		//里(String transCode, Object reqServiceBody, Object rspServiceBody)
		
		//方式1：Dao->Service.相关包->Service相关里面TranService->Service里面TransServiceFactory->TransCoreService2的handlerBussiness(tranCode,map)
		//	         参考TransCoreService2的main(需要Rsp如or01里面XML配置,TransCoreService2里面main)
		
		//方式2：Dao->Service.相关包->socket.service.config里面InitTransService->or01->socket.service.TransCoreService里面handlerBussiness参考
		//     (ParseXmlMessage里面main,TransCoreService里面main)
		
		Long start = System.currentTimeMillis();	
		ExecutorService threads = Executors.newFixedThreadPool(200);
		
		List<Stock> list = new ArrayList<>();
		for (int i =0; i < 10; i++) {
			Stock stock = new Stock();
			stock.setItemCode("0001000" + i);
			stock.setQty(10000);
			list.add(stock);
		}
		
		for(int i = 0; i < 98000; i++) {
			Future<String> task = threads.submit(new ClientThread(list));
		}
		
		while (true) {
			try {
				SocketClient socketClient = new SocketClient();
				String stockReqXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><reqService><reqHeader><tranCode>OR01</tranCode><transDate>20190619</transDate><transTime>131452</transTime></reqHeader><body></body></reqService>";
				int srcLength = stockReqXml.getBytes("utf8").length;
				String newStockReqxml = String.format("%6d", srcLength).replace(" ", "0") + stockReqXml;
				//商品查询响应xml
				String stockRspXml = socketClient.start(newStockReqxml, SERVER_IP, SERVER_PORT);
				// 解析服务端返回的查询库存报文
				Thread.sleep(20);
				RspOR01Service rspOR01Service = ReflectParseUtils.XmlToJava(stockRspXml, RspOR01Service.class);
				int nums = rspOR01Service.getBody().getNums();
				// 如果nums为0，表示没有库存，结束
				if (nums == 0) {
					LOG.debug("所有商品均无库存，秒杀活动结束！");
					Long end = System.currentTimeMillis();
					LOG.info("执行时间：{}ms", (end-start));
					break;
				} else {
					// 根据有库存的商品，随机购买、
					List<Stock> row = rspOR01Service.getBody().getRow();
					Random random = new Random();
					int i = random.nextInt(row.size());
					Future<String> task = threads.submit(new ClientThread2(row.get(i)));
				}
			} catch (Exception e) {
				LOG.error("异常退出:{}", e);
				break;
			}
		}
		
		threads.shutdown();
		
		Long end = System.currentTimeMillis();
		LOG.info("执行时间：{}ms", (end-start));
		
	}
}
