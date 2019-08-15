package com.spdb.training.services.stock;

import java.sql.SQLException;
import java.util.List;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.dao.UserinfoDao;
import com.spdb.training.exception.ExceptionHandle;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;

/**
* @ClassName: StockServiceImpl
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public class StockServiceImpl implements StockService{
	private static ILog logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Override
	public Stock queryStockByItemCode(String itemCode) {
//		try {
//			return
//		} catch (SQLException e) {
//			ExceptionHandle.handle(e);
//		}
		return null;
	}

	@Override
	public List<Stock> queryStockHaveQty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStockQtyByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
