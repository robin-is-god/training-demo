package com.spdb.training.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.beans.stock.StockRsp;
import com.spdb.training.beans.trans.TransReqContext;
import com.spdb.training.beans.trans.TransRspContext;
import com.spdb.training.exception.BusinessException;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.services.stock.StockServiceImpl;

/**
* @ClassName: StockTransServices
* @Description: TODO:
* @author Robin
* @date 2019骞�8鏈�15鏃�
*
*/

public class StockTransServices implements ITransServices<Stock, StockRsp>{

	ILog log = LoggerFactory.getLogger(StockTransServices.class);
	private StockServiceImpl stockServiceImpl;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	
	@Override
	public void execute(TransReqContext<Stock> reqContext, TransRspContext<StockRsp> rspContext) {
		if (stockServiceImpl == null) {
			stockServiceImpl = new StockServiceImpl();
		}
		
		List<Stock> row = this.queryQtyStock();
		if (row == null || row.isEmpty()) {
			throw new BusinessException(ResultCodeEnum.TRAINPB0002.getCode(), ResultCodeEnum.TRAINPB0002.getMsg(),
					"");
		} else {
			log.info("所有有库存商品查询信息:{}", row.toString());
		}
		StockRsp context = rspContext.getContext();
		context.setNums(row.size());
		context.setRow(row);
	}
	
	private List<Stock> queryQtyStock(){
		readLock.lock();
		try {
			return stockServiceImpl.queryStockHaveQty();
		} finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		StockServiceImpl serviceImpl = new StockServiceImpl();
		
		List<Stock> row = serviceImpl.queryStockHaveQty();
		if (row == null || row.isEmpty()) {
			throw new BusinessException(ResultCodeEnum.TRAINPB0002.getCode(), ResultCodeEnum.TRAINPB0002.getMsg(),
					"");
		} else {
			System.out.println("所有有库存商品查询信息:{}" +  row.toString());
		}
	}
}
