package com.spdb.training.services.stock;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.dao.StockInfoDao;
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
		Stock stock = null;
		try {
			stock = StockInfoDao.queryByItemCode(itemCode);
			logger.info("根据商品代码查询商品库存成功！");
			return stock;
		} catch (SQLException e) {
			ExceptionHandle.handle(e);
		}
		return stock;
	}

	@Override
	public List<Stock> queryStockHaveQty() {
		List<Stock> list = null;
		try {
			list = StockInfoDao.queryIFQty();
			logger.info("查询有库存的商品成功：{}", list.toString()); 
			return list;
		} catch (SQLException e) {
			ExceptionHandle.handle(e);
		}
		return list; 
	}
	/**
	 * @疑问：对返回值：boolean的意义不太确定是什么。
	 * @方法名：updateStockQtyByItemCode
	 * @返回值意义说明：true:更新行数>0
	 *              false:更新行数<=0	 * 
	 * @author:annliao
	 * @date:2019年8月16日
	 */

	@Override
	public boolean updateStockQtyByItemCode(String itemCode,int decNum) {
		int rowsAffected;
		try {
			rowsAffected = StockInfoDao.updateStock(itemCode, decNum);
			if (rowsAffected <= 0) {
				logger.warn("购买更新库存影响0行");
				return false;
			}else {
				logger.info("购买更新库存成功");
				return true;
			}
		} catch (Exception e) {
			ExceptionHandle.handle(e);
		}
		return false;
	}
}
