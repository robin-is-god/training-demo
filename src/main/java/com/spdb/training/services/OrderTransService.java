package com.spdb.training.services;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.spdb.training.beans.order.Order;
import com.spdb.training.beans.order.OrderRsp;
import com.spdb.training.beans.stock.Stock;
import com.spdb.training.beans.trans.TransReqContext;
import com.spdb.training.beans.trans.TransRspContext;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.services.order.OrderServiceImpl;
import com.spdb.training.services.stock.StockServiceImpl;
import com.spdb.training.utils.SimpleDateUtils;


/**
* @ClassName: OrderTransService
* @Description: TODO:
* @author Robin
* @date 2019年8月20日
*
*/

public class OrderTransService implements ITransServices<Order, OrderRsp>{
	
	ILog log = LoggerFactory.getLogger(OrderTransService.class);
	private OrderServiceImpl orderServiceImpl;
	private StockServiceImpl stockServiceImpl;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	
	@Override
	public void execute(TransReqContext<Order> reqContext, TransRspContext<OrderRsp> rspContext) {
		if (orderServiceImpl == null) {
			orderServiceImpl = new OrderServiceImpl();
		}
		
		if (stockServiceImpl == null) {
			stockServiceImpl = new StockServiceImpl();
		}
		Order context = reqContext.getContext();
		log.info(context.toString());
		if(this.queryStockByItemCode(context.getOrderCode()).getQty() > 0){
		//if(stockServiceImpl.queryStockByItemCode(context.getOrderCode()).getQty() > 0){
			try {
				context.setOrderDate(SimpleDateUtils.getYYYYMMDD());
				context.setOrderTime(SimpleDateUtils.getHHMMSS());
				orderServiceImpl.insert(context);
				this.updateStockQty(context.getOrderCode(), context.getOrderNum());
				//stockServiceImpl.updateStockQtyByItemCode(context.getOrderCode(), context.getOrderNum());
			} catch (Exception e) { 
				log.error("订单生成过程中错误:{}", e);
			}
		}
	}
	
	private boolean updateStockQty(String itemCode, int qty) {
		writeLock.lock();
		try {
			return stockServiceImpl.updateStockQtyByItemCode(itemCode, qty);
		} finally {
			writeLock.unlock();
		}
	}
	
	private Stock queryStockByItemCode(String itemCode) {
		readLock.lock();
		try {
			return stockServiceImpl.queryStockByItemCode(itemCode);
		} finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
